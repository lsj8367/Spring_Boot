package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString(exclude = {"user", "orderDetailList"})
@EntityListeners(AuditingEntityListener.class) //해당 entity리스너 는 AuditingEntityListener를 쓰겠다는것을 가리킴
public class OrderGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private String orderType; //주문의 형태 일괄 / 개별

    private String revAddress;

    private String revName;

    private String paymentType; //계산방법 카드,현금

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    private LocalDateTime orderAt;

    private LocalDateTime arrivalDate;

    @CreatedDate //해당 객체가 수정이 일어나면 시간을 바꿔줌
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy; //LoginUserAuditorAware 리턴값을 받음

    @LastModifiedDate // 객체가 수정되거나 생성되면 시간이 현재시간으로 됨
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy; //LoginUserAuditorAware 리턴값을 받음


    // OrderGroup N : 1 User 외래키 조인
    @ManyToOne
    private User user; // user 는 mappedby와 일치해야함

    // OrderGroup 1 : N OrderDetail
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderGroup")
    private List<OrderDetail> orderDetailList;

}
