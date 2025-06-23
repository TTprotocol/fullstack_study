package com.yuco.stock.controller;

import com.yuco.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {
    final private StockService service;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("list");
        model.addAttribute("list", service.getList());
    }
}
