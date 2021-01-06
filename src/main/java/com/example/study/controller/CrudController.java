package com.example.study.controller;

import com.example.study.ifs.CRUDInterface;
import com.example.study.model.network.Header;
import org.springframework.web.bind.annotation.*;

public abstract class CrudController<Req, Res> implements CRUDInterface<Req, Res> {

    protected CRUDInterface<Req, Res> baseService;//상속받은 클래스만 접근
    // crud 인터페이스를 implements 했다면 적용된다.

    @Override
    @PostMapping("")
    public Header<Res> create(@RequestBody Header<Req> request) {
        return baseService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<Res> read(@PathVariable Long id) {
        return baseService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<Res> update(@RequestBody Header<Req> request) {
        return baseService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return baseService.delete(id);
    }
}
