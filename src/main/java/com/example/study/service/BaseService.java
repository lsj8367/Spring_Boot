package com.example.study.service;

import com.example.study.ifs.CRUDInterface;
import com.example.study.model.network.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseService<Req, Res, Entity> implements CRUDInterface<Req, Res> { // CrudController에 적용

    @Autowired(required = false) //필수적인건 아니다.
    protected JpaRepository<Entity, Long> baseRepository;
    //JpaRepository<Item, Long>
}
