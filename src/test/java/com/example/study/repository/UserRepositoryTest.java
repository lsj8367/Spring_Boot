package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {
    // Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository; //매번 객체를 생성해줄 필요가없음. (싱글톤)

    @Test //테스트용
    public void create(){
        // String sql = "insert into user (%s, %s, %d) values (account, email, age);
        User user = new User();
        //user.setId(); //자동으로 올라가니까 필요 X
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-3333-3333");
        user.setCreatedAt(LocalDateTime.now()); //현재시간
        user.setCreatedBy("TestUser3");

        // Hibernate: insert into user (account, created_at, created_by, email, phone_number, updated_at, updated_by) values (?, ?, ?, ?, ?, ?, ?) 이걸 해줄 필요가 없어짐.

        User newUser = userRepository.save(user); //객체를 db에 저장
        System.out.println("newUser : " + newUser);
    }

    @Test
    @Transactional
    public void read(){ //@RequestParam Long id
        //userRepository.findAll(); // select문으로 테이블 전체

        //select * from user where id = ?
        //Optional<User> user = userRepository.findById(7L); //long type이라 2L넣음 아이디타입 2번째
        Optional<User> user = userRepository.findByAccount("TestUser03");

        user.ifPresent(selectUser ->{ //유저에 맞는 아이디가 있으면 결과를 받겠다.
//            System.out.println("user : " + selectUser);
//            System.out.println("email : " + selectUser.getEmail()); // 해당유저의 이메일
            selectUser.getOrderDetailList().stream().forEach(detail -> {
                Item item = detail.getItem();
                System.out.println(item); //7번 이용자가 1번 아이템을 가지고있는것 확인

            });


        });
    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(2L);

        //update user set id=...
        //JPA에서는 해당 id 존재여부를 확인하고 이 값을 신규로 만들지 않고 업데이트 해준다.
        user.ifPresent(selectUser ->{ //유저에 맞는 아이디가 있으면 결과를 받겠다.
            //selectUser.setId(); //이것을 실행하면 여기가 우선으로 작용해서 Optional이 작동하지않음.
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);

        });
    }

    //@DeleteMapping("/api/user")
    @Test
    @Transactional // 트랜잭션처리 롤백처리해줌
    public void delete(){ //@RequestParam Long id
        Optional<User> user = userRepository.findById(3L);

        Assertions.assertTrue(user.isPresent()); //무조건적으로 있어야한다. 없으면 에러문구 출력.


        user.ifPresent(selectUser -> { //있는데이터를 삭제
            userRepository.delete(selectUser); //db삭제
        });

        Optional<User> deleteUser = userRepository.findById(3L); //다시 db조회

//        if(deleteUser.isPresent()){
//            System.out.println("데이터 존재" + deleteUser.get());
//        }else{
//            System.out.println("데이터 삭제됨.");
//        }

        Assertions.assertFalse(deleteUser.isPresent()); //반드시 false여야한다.

    }
}

