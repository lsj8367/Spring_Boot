package com.example.study.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderDetailStatus {
//    REGISTERED(0, "등록", "상품 등록 상태"),
//    UNREGISTERED(1, "해지", "상품 해지 상태"),
//    WAITING(2, "검수(대기)", "상품 검수 상태"),
    ORDERING(0, "주문중", "상품 주문중 상태"),
    COMPLETE(1, "완료", "상품 주문완료 상태"),
    CONFIRM(2, "확인", "상품 확인 상태")
    ;

    private Integer id;
    private String title;
    private String description;
}
