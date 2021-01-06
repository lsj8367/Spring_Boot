package com.example.study.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStatus {
    ORDERING(0, "주문중", "상품 주문중 상태"),
    COMPLETE(1, "완료", "상품 주문완료 상태"),
    CONFIRM(2, "확인", "상품 확인 상태")
    ;

    private Integer id;
    private String title;
    private String description;
}
