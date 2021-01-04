package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.OrderDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class OrderDetailRepositoryTest extends StudyApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setStatus("Waiting");
        orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2)); //현재일로부터 2일 추가
        orderDetail.setQuantity(1); //수량
        orderDetail.setTotalPrice(BigDecimal.valueOf(900000)); //총가격
        orderDetail.setCreatedAt(LocalDateTime.now());
        orderDetail.setCreatedBy("AdminServer");

        //어떤 장바구니
        orderDetail.setOrderGroupId(1L);
        //어떤 상품
        orderDetail.setItemId(1L); //어떠한 상품

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        Assertions.assertNotNull(newOrderDetail);
    }

    @Test
    public void read(){
        Long id = 1L;

        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(id);

        Assertions.assertTrue(orderDetail.isPresent());



    }


}
