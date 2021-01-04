package com.example.study.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"orderDetailList", "partner"})
@EntityListeners(AuditingEntityListener.class) //해당 entity리스너 는 AuditingEntityListener를 쓰겠다는것을 가리킴
@Builder // build객체로 다른곳에서 생성자 매번 생성하지않고 하나씩 추가하는 기능
@Accessors(chain = true) //update할때도 .set 으로 다 연결해줌
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private String name;

    private String title;

    private String content;

    private Integer price;

    private String brandName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    @CreatedDate //해당 객체가 수정이 일어나면 시간을 바꿔줌
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy; //LoginUserAuditorAware 리턴값을 받음

    @LastModifiedDate // 객체가 수정되거나 생성되면 시간이 현재시간으로 됨
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy; //LoginUserAuditorAware 리턴값을 받음

    // Item N : 1 Partner
    @ManyToOne
    private Partner partner;
    //private Long partnerId;

    //Item 1 : N OrderDetail
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;


    //1 : N 아이템 입장에서 본인은 1 주문은 n이기 때문
    // LAZY = 지연로딩, EAGER = 즉시로딩
    // LAZY = SELECT * FROM item where id = ?
    // LAZY는 따로 메소드를 호출하지 않는이상 조인하지 않음.

    // EAGER는 즉시 모든것을 로딩함. 연관되어있는 모든 테이블에 대해 조인함 그렇기 때문에 성능 저하 우려됨.  1 : 1 관계에서만 추천하는 방식임.
    // item_id = order_detail.item_id
    // user_id = order_detail.user_id
    // where item.id = ?
    // EAGER = from item item0_ left outer join order_detail orderdetai1_ on item0_.id=orderdetai1_.item_id left outer join user user2_ on orderdetai1_.user_id=user2_.id where item0_.id=?
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "item")
//    private List<OrderDetail> orderDetailList;

}
