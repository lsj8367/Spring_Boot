package com.example.study.model.network.response;

import com.example.study.model.enumclass.OrderDetailStatus;
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
public class OrderDetailApiResponse {

    private Long id;

    private OrderDetailStatus status;

    private LocalDateTime arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

    private Long itemId;

    private Long orderGroupId;


}
