package org.scoula.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor    // 권장사항
public class Restaurant {
//    @Autowired
    private final Chef chef;    // DI 주입 대상은 final로 지정
}
