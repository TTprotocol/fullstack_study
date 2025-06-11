package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class HomeController {
//    @GetMapping("/")
//    public String home() {
//        log.info("=============> HomeController");
//        return "index";
//    }

    @GetMapping("/")
    public String home(Model model) {
        // Model : spring에서 제공하는 데이터 전달 객체
        // request scope에 데이터 저장
        model.addAttribute("name", "홍길동");

        return "index";
    }
}
