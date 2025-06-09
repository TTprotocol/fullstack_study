package org.exam.service;

import org.exam.domain.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("rescueCenter")
public class RescueCenter {

    // @Autowired + @Qualifier("밤비")로 밤비만 주입
    @Autowired
    @Qualifier("밤비")
    private Dog dog;

    // 구조 완료 시 자동 실행, 강아지 정보 출력
    @PostConstruct
    public void rescueDog() {
        System.out.println("구조된 강아지 정보: " + dog);
    }
}
