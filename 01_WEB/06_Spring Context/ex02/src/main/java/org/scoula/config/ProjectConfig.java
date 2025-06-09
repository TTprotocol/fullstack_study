package org.scoula.config;

import org.scoula.beans.Parrot;
import org.scoula.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    public Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean
    public Person person(Parrot parrot) {
        Person p = new Person();
        p.setName("Ella");
        // Parrot을 설정하는 방법
        // 1. 직접 메서드 호출
        // p.setParrot(parrot());   // 스프링 컨테이너에 parrot 객체가 있다면, 그 객체를 가져온다.
        // 2. 매개변수로 넘겨받기
        p.setParrot(parrot);
        return p;
    }
}
