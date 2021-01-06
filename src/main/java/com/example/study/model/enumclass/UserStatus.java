package com.example.study.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserStatus {
    //이 두개만 들어올수가 있게된다.
    REGISTERED(0, "등록", "사용자 등록상태"),
    UNREGISTERED(1, "해지", "사용자 해지상태")
    ;

    private Integer id;
    private String title;
    private String description;
}
