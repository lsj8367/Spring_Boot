package com.example.study.model.network.request;

import com.example.study.model.enumclass.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserApiRequest {

    private Long id;

    private String account;

    private String password;

    private UserStatus status;

    private String email;

    private String phoneNumber;

    //이 다음은 서버에서 생성해주기 때문에 생략
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;

}
