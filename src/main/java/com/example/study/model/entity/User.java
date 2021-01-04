package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data //getter setter 생성 메소드
@AllArgsConstructor // 생성자 오버로딩 된것들 전부 생성해줌.
@NoArgsConstructor // 기본생성자 생성
@Entity // == table
//@Table(name = "user") //클래스명과 테이블이름이 같으면 이렇게 안해줘도됨
public class User { //클래스의 이름이 DB테이블과 동일하게
//    1)직접 할당 : 기본 키를 애플리케이션에서 직접 엔티티클래스의 @Id 필드에 set해준다.
//    2)자동 생성 : 대리 키 사용 방식
//    - IDENTITY : 기본 키 생성을 데이터베이스에 위임한다.(ex MySQL - AUTO INCREMENT...)

    // Jpa Entity 및 column은 자동으로 db 칼럼과 매칭시켜준다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //전략옵션
    private Long id;

    //@Column(name = "account") 칼럼명과 맞춰주기
    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    // 1 : N
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user") // mapping은 Orderdetail의 user 변수와 같아야함.
//    private List<OrderDetail> orderDetailList; //Lombok Tostring 메소드가 list로 결합되면서 무한참조가 발생함.
}
