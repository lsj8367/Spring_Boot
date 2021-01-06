package com.example.study.controller;

import com.example.study.ifs.CRUDInterface;
import com.example.study.model.network.Header;
import com.example.study.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Component
public abstract class CrudController<Req, Res, Entity> implements CRUDInterface<Req, Res> {

    @Autowired(required = false)
    protected BaseService<Req, Res, Entity> baseService;//상속받은 클래스만 접근
    // crud 인터페이스를 implements 했다면 적용된다.


    //페이징처리
    @GetMapping("")
    public Header<List<Res>> search(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 10) Pageable pageable){ //id순으로 10개씩 정렬
        log.info("{}",pageable);
        return baseService.search(pageable);
    }


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
