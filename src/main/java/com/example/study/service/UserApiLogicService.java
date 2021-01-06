package com.example.study.service;

import com.example.study.ifs.CRUDInterface;
import com.example.study.model.entity.User;
import com.example.study.model.enumclass.UserStatus;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import com.example.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service //서비스로 동작하게됨
public class UserApiLogicService implements CRUDInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    //1. request Data 가져오기
    //2. user 생성
    //3. 생성된 데이터로 userApiResponse를 return 해준다.
    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {

        //1. request data
        UserApiRequest userApiRequest = request.getData();

        //2. 유저 생성
        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status(UserStatus.REGISTERED)
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();

        User newUser = userRepository.save(user);

        //3. 생성된 데이터로 UserApiResponse return
        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        // 1. id -> repository getOne, getById
        //Optional<User> optional = userRepository.findById(id);

        // 2. user -> userApiresponse return


        return userRepository.findById(id)
                .map(this::response) //있는 경우
                .orElseGet(
                        ()->Header.ERROR("데이터 없음")
                        ); //없는 경우

    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        //1. data
        UserApiRequest userApiRequest = request.getData();

        //2. id -> user
        Optional<User> optional = userRepository.findById(userApiRequest.getId());

        return optional.map(user -> {
            //3. data -> update
            // id
            user.setAccount(userApiRequest.getAccount())
                    .setPassword(userApiRequest.getPassword())
                    .setStatus(userApiRequest.getStatus()) // 오타가 있을수 있는 형태는 enum으로 저장해둔다.
                    .setPhoneNumber(userApiRequest.getPhoneNumber())
                    .setEmail(userApiRequest.getEmail())
                    .setRegisteredAt(userApiRequest.getRegisteredAt())
                    .setUnregisteredAt(userApiRequest.getUnregisteredAt());
            return user;
        })
        .map(user -> userRepository.save(user))             // update 갱신
        .map(updateUser -> response(updateUser))            // userApiResponse 생성
        .orElseGet(() -> Header.ERROR("데이터 없음"));


        //4. userApiRequest
    }

    @Override
    public Header delete(Long id) {
        // 1. id -> repository -> user

        Optional<User> optional = userRepository.findById(id);

        //2. repository -> delete

        return optional.map(user -> {
            userRepository.delete(user);

            return Header.OK();
        }).orElseGet(()-> Header.ERROR("데이터 없음"));
        //3. response return
    }

    private Header<UserApiResponse> response(User user){
        // user 객체를 UserApiResponse로 바꿔주는 메소드

        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword()) // todo 암호화, 길이
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();

        //Header + data return
        return Header.OK(userApiResponse);
    }

}
