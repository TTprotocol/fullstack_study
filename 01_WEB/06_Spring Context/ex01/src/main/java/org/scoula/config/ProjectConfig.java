package org.scoula.config;

import org.scoula.domain.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // 1. Spring 설정 클래스 지정. 이게 있어야 bean 포함 가능
public class ProjectConfig {
    // 2. 빈을 반환하는 메서드 생성
    @Bean // Spring 컨테이너 안에 빈으로 등록
    Parrot parrot() {
        var p = new Parrot();
        p.setName("Koko");
        return p;   // 빈으로 등록할 객체 반환
    }

    @Bean
    String hello() {
        return "Hello";
    }

    @Bean
    Integer ten() {
        return 10;
    }
}
