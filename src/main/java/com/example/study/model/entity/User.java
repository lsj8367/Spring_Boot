package com.example.study.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data //getter setter 생성 메소드
@AllArgsConstructor // 생성자 오버로딩 된것들 전부 생성해줌.
@NoArgsConstructor // 기본생성자 생성
@Entity // == table
//@Table(name = "user") //클래스명과 테이블이름이 같으면 이렇게 안해줘도됨
@ToString(exclude = {"orderGroupList"}) // 롬복이 ordergroup은 제외함
@EntityListeners(AuditingEntityListener.class) //해당 entity리스너 는 AuditingEntityListener를 쓰겠다는것을 가리킴
@Builder // build객체로 다른곳에서 생성자 매번 생성하지않고 하나씩 추가하는 기능
@Accessors(chain = true) //update할때도 .set 으로 다 연결해줌
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

    @CreatedDate //해당 객체가 수정이 일어나면 시간을 바꿔줌
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy; //LoginUserAuditorAware 리턴값을 받음

    @LastModifiedDate // 객체가 수정되거나 생성되면 시간이 현재시간으로 됨
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy; //LoginUserAuditorAware 리턴값을 받음

    // 1 : N
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user") // mapping은 Orderdetail의 user 변수와 같아야함.
//    private List<OrderDetail> orderDetailList; //Lombok Tostring 메소드가 list로 결합되면서 무한참조가 발생함.

    // User 1 : N OrderGroup 관계
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderGroup> orderGroupList;
}
