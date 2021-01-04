package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //order_detail 테이블
@ToString(exclude = {"item", "orderGroup"}) //연관관계로 user, item 클래스를 묶었을때 안해주면 stackoverflow 발생
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDateTime arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    //Order Detail N : 1 Item
    //private Long itemId;
    @ManyToOne
    private Item item;

    //OrderDetail N : 1 OrderGroup
    //private Long orderGroupId;
    @ManyToOne
    private OrderGroup orderGroup; // 변수이름은 MappedBy와 일치해야함

    /*
    //자기 자신 테이블의 위치에서 N인지 1인지에 따라 어노테이션 참조
    // N : 1 관계
    @ManyToOne
    private User user; // Long타입이 아니라 USER타입으로 바꿔야함
    //User 클래스의  Onetomany와 연결

    // N : 1
    @ManyToOne
    private Item item; // 변수이름이 Item mapped와 동일해야함
     */



}
