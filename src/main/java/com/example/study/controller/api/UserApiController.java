package com.example.study.controller.api;

import com.example.study.controller.CrudController;
import com.example.study.ifs.CRUDInterface;
import com.example.study.model.entity.User;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import com.example.study.model.network.response.UserOrderInfoApiResponse;
import com.example.study.repository.UserRepository;
import com.example.study.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Slf4j // simple logging
@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse, User> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    @GetMapping("/{id}/orderInfo")
    public Header<UserOrderInfoApiResponse> orderInfo(@PathVariable Long id){
        return userApiLogicService.orderInfo(id);
    }
//
//    @PostConstruct
//    public void init(){
//        this.baseService = userApiLogicService;
//    }

    /*
    // C
    @Override
    @PostMapping("") // api/user
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request){
        log.info("{}",request);
        return userApiLogicService.create(request);
    }

    // R
    @Override
    @GetMapping("{id}") // api/user/{id}
    public Header<UserApiResponse> read(@PathVariable(name = "id") Long id) { //getmapping 에 들어가는 값과 같게 바꿔줌
        log.info("{}",id);
        return userApiLogicService.read(id);
    }

    // U
    @Override
    @PutMapping("") //api/user
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
        log.info("{}",request);
        return userApiLogicService.update(request);
    }

    // D
    @Override
    @DeleteMapping("{id}") // api/user/{id}
    public Header<UserApiResponse> delete(@PathVariable Long id) {
        log.info("delete : {}", id);
        return userApiLogicService.delete(id);
    }
     */
}
