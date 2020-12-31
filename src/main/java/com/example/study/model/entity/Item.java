package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer price;

    private String content;

    //1 : N 아이템 입장에서 본인은 1 주문은 n이기 때문
    // LAZY = 지연로딩, EAGER = 즉시로딩
    // LAZY = SELECT * FROM item where id = ?
    // LAZY는 따로 메소드를 호출하지 않는이상 조인하지 않음.

    // EAGER는 즉시 모든것을 로딩함. 연관되어있는 모든 테이블에 대해 조인함 그렇기 때문에 성능 저하 우려됨.  1 : 1 관계에서만 추천하는 방식임.
    // item_id = order_detail.item_id
    // user_id = order_detail.user_id
    // where item.id = ?
    // EAGER = from item item0_ left outer join order_detail orderdetai1_ on item0_.id=orderdetai1_.item_id left outer join user user2_ on orderdetai1_.user_id=user2_.id where item0_.id=?
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "item")
    private List<OrderDetail> orderDetailList;

}
