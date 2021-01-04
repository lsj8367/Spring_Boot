package com.example.study.controller.api;

import com.example.study.ifs.CRUDInterface;
import com.example.study.model.network.Header;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CRUDInterface {

    // C
    @Override
    public Header create(){
        return null;
    }

    // R
    @Override
    public Header read(Long id) {
        return null;
    }

    // U
    @Override
    public Header update() {
        return null;
    }

    // D
    @Override
    public Header delete(Long id) {
        return null;
    }







}
