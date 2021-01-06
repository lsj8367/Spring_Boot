package com.example.study.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStatus {
    COMPLETE(0, "완료", "주문 완료"),
    WAITING(1, "대기", "입금 대기")
    ;

    private Integer id;
    private String title;
    private String description;
}
