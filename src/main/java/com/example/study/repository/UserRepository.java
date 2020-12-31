package com.example.study.repository;

import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { // 제네릭안에는 Table명과, primary key 값을 넣어줌
    
    //오버라이드 하는느낌
    
    //select * from user where account = ? 와 같음 << id 넣고
    Optional<User> findByAccount(String account); //계정 매칭하는것을 찾겠다. 라는 의미

    Optional<User> findByEmail(String email);

    //select * from user where account = ? and email = ? 과 같다.
    Optional<User> findByAccountAndEmail(String account, String email); // 매개변수는 findby뒤에 붙은 순서대로 매핑이 된다.

}
