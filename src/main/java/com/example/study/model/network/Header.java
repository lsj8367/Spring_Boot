package com.example.study.model.network;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@JsonInclude() //다루는 값을 설정해줄수도 있음.
public class Header<T> {

    // api 통신시간 (LocalDateTime 사용해도 무방)
    //@JsonProperty("transaction_time") //json 키 이름 매핑 시켜줄수도 있음.
    private String transactionTime;

    // api 응답코드
    private String resultCode;

    // api 부가 설명
    private String description;

    private T data;
}
