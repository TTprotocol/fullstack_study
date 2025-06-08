package org.scoula.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MenuController {
    public String getList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<String> list = Arrays.asList("오리지널 타코야키", "치즈 타코야키");
        req.setAttribute("menuList", list);

        System.out.println("Get /menu/list");
        return "/menu/list";
    }

}
