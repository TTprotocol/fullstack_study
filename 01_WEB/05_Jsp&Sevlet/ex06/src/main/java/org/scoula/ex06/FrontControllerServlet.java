package org.scoula.ex06;

import org.scoula.ex06.command.Command;
import org.scoula.ex06.controller.HomeController;
import org.scoula.ex06.controller.TodoController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServlet", value = "/")
public class FrontControllerServlet extends DispatcherServlet {
//    // 요청 방식별로 요청을 저장할 맵
//    Map<String, Command> getMap;
//    Map<String, Command> postMap;
//
//    String prefix = "/WEB-INF/views/";
//    String suffix = ".jsp";
    HomeController homeController = new HomeController();
    TodoController todoController = new TodoController();

    @Override
    public void init() {
        getMap = new HashMap<>();
        postMap = new HashMap<>();

        getMap.put("/", homeController::getIndex);

        // get 요청 매핑
        getMap.put("/todo/list", todoController::getList);
        getMap.put("/todo/view", todoController::getView);
        getMap.put("/todo/create", todoController::getCreate);
        getMap.put("/todo/update", todoController::getUpdate);

        // post 요청 매핑
        postMap.put("/todo/create", todoController::postCreate);
        postMap.put("/todo/update", todoController::postUpdate);
        postMap.put("/todo/delete", todoController::postDelete);
    }

//    @Override
//    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        Command command = getCommand(req);
//        if (command != null) {
//            execute(command, req, resp);
//        } else {
//            // 404 에러 처리
//            String view = prefix + "404" + suffix;
//            RequestDispatcher dis = req.getRequestDispatcher(view);
//            dis.forward(req, resp);
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//    }
//
//    private String getCommandName(HttpServletRequest request) {
//        String requestURI = request.getRequestURI();
//        String contextPath = request.getContextPath();
//        return requestURI.substring(contextPath.length());
//    }
//
//    private Command getCommand(HttpServletRequest req) {
//        String commandName = getCommandName(req);
//        Command command;
//        if (req.getMethod().equalsIgnoreCase("GET")) {
//            command = getMap.get(commandName);
//        } else {
//            command = postMap.get(commandName);
//        }
//        return command;
//    }
//
//    public void execute(Command command, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        String viewName = command.execute(req, resp);
//        if (viewName.startsWith("redirect:")) { // redirect 처리
//            resp.sendRedirect(viewName.substring("redirect:".length()));
//        } else { // forward 처리
//            String view = prefix + viewName + suffix;
//            RequestDispatcher dis = req.getRequestDispatcher(view);
//            dis.forward(req, resp);
//        }
//    }
}
