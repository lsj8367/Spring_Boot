package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString(exclude = {"partnerList"})
@EntityListeners(AuditingEntityListener.class) //해당 entity리스너 는 AuditingEntityListener를 쓰겠다는것을 가리킴
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String title;

    @CreatedDate //해당 객체가 수정이 일어나면 시간을 바꿔줌
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy; //LoginUserAuditorAware 리턴값을 받음

    @LastModifiedDate // 객체가 수정되거나 생성되면 시간이 현재시간으로 됨
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy; //LoginUserAuditorAware 리턴값을 받음

    //Category 1 : N Partner
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Partner> partnerList;

}
