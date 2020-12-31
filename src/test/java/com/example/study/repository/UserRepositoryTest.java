package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserRepositoryTest extends StudyApplicationTests {
    // Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository; //매번 객체를 생성해줄 필요가없음. (싱글톤)

    @Test //테스트용
    public void create(){
        // String sql = "insert into user (%s, %s, %d) values (account, email, age);
        User user = new User();
        //user.setId(); //자동으로 올라가니까 필요 X
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-3333-3333");
        user.setCreatedAt(LocalDateTime.now()); //현재시간
        user.setCreatedBy("TestUser3");

        // Hibernate: insert into user (account, created_at, created_by, email, phone_number, updated_at, updated_by) values (?, ?, ?, ?, ?, ?, ?) 이걸 해줄 필요가 없어짐.

        User newUser = userRepository.save(user); //객체를 db에 저장
        System.out.println("newUser : " + newUser);
    }

    public void read(){

    }

    public void update(){

    }

    public void delete(){

    }

}

