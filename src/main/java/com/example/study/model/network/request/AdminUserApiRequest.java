package com.example.study.model.network.request;

import com.example.study.model.enumclass.AdminStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminUserApiRequest {
    private Long id;

    private String account;

    private String password;

    private AdminStatus status;

    private String role;

    private LocalDateTime LastLoginAt;

    private Integer LoginFailCount;

    private LocalDateTime passwordUpdatedAt;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;
}
