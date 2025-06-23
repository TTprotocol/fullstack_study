package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 스프링이 컨트롤러로 인식하고 bean 등록
@Log4j2
public class HomeController {
    @GetMapping("/")
    public String home() {
//        log.info("=============> HomeController");
//        return "index";
        return "redirect:/board/list";
    }
}
