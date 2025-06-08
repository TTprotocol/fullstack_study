package org.scoula.exam;

import org.scoula.exam.dispatcher.DispatchServlet;
import org.scoula.exam.controller.HomeController;
import org.scoula.exam.controller.MenuController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.util.HashMap;

@WebServlet(name = "frontControllerExamServlet", value = "/exam/*")
public class FrontControllerServlet extends DispatchServlet {

    HomeController homeController = new HomeController();
    MenuController menuController = new MenuController();

    @Override
    public void init() {
        getMap = new HashMap<>();
        postMap = new HashMap<>();

        getMap.put("/exam", homeController::getIndex);

        // get 요청 매핑
        getMap.put("/exam/menu/list", menuController::getList);

        // post 요청 매핑
    }

}
