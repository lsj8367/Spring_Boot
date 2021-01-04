package com.example.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration //설정파일이다 라고 암시
@EnableJpaAuditing // 활성화시킴 JPA감시
public class JpaConfig {
}
