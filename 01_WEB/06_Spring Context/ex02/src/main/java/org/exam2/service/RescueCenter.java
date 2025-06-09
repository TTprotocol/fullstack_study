package org.exam2.service;

import org.exam2.domain.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("rescueCenter")
public class RescueCenter {
    private List<Dog> dogs;

    public RescueCenter(List<Dog> dogs) {
        this.dogs = dogs;
    }

    @PostConstruct
    public void rescueDogs() {
        Map<String, Integer> map = new HashMap<>();

        map.put("진돗개", 1);
        map.put("시바견", 2);
        map.put("푸들", 3);

        dogs.sort(Comparator.comparingInt(
            dog -> map.getOrDefault(dog.getBreed(), 100)
        ));

        System.out.println("[구조 우선순위에 따라 구조를 시작합니다.]");
        for (Dog dog : dogs) {
            System.out.println("안아줌 완료 : " + dog);
        }
    }
}
