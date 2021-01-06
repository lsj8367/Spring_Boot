package com.example.study.model.network.response;

import com.example.study.model.enumclass.OrderPaymentType;
import com.example.study.model.enumclass.OrderStatus;
import com.example.study.model.enumclass.OrderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderGroupApiResponse {
    private Long id;

    private OrderStatus status;

    private OrderType orderType;

    private String revAddress;

    private String revName;

    private OrderPaymentType paymentType;

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    private LocalDateTime orderAt;

    private LocalDateTime arrivalDate;

    private Long userId;
}
