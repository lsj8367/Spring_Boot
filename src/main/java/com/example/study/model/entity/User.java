package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data //getter setter 생성 메소드
@AllArgsConstructor // 생성자 생성
@Entity // == table
//@Table(name = "user") //클래스명과 테이블이름이 같으면 이렇게 안해줘도됨
public class User { //클래스의 이름이 DB테이블과 동일하게

    // Jpa Entity 및 column은 자동으로 db 칼럼과 매칭시켜준다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //전략옵션
    private Long id;

    //@Column(name = "account") 칼럼명과 맞춰주기
    private String account;

    private String email;

    private String phoneNumber;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    public User() {
    }
}
