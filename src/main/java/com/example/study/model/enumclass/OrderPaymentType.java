package com.example.study.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderPaymentType {

    CARD(0,"카드", "카드 계산"),
    CASH(1, "현금", "현금 계산"),
    BANK_TRANSFER(2, "이체", "계좌 이체"),
    CHECK_CARD(3, "체크카드", "체크 카드")
    ;

    private Integer id;
    private String title;
    private String description;
}
