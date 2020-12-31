package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.OrderDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class OrderDetailRepositoryTest extends StudyApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderAt(LocalDateTime.now());

        //어떤 사람
        //orderDetail.setUserId(7L); //index id 7번의 사람

        //어떤 상품
        //orderDetail.setItemId(1L); //item 데이터의 1번

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        Assertions.assertNotNull(newOrderDetail);
    }

    @Test
    public void read(){
        Long id = 1L;

        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(1L);

        Assertions.assertTrue(orderDetail.isPresent());



    }


}
