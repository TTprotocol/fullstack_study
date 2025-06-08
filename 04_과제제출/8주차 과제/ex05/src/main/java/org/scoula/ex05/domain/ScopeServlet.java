package org.scoula.ex05.domain;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
    // 어플리케이션 영역 접근용 변수
    ServletContext sc;

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 어플리케이션 스코프 객체 얻기
        sc = config.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 어플리케이션 스코프에 데이터 저장
        sc.setAttribute("scopeName", "applicationScope 값"); // Application Scope

        // 세션 스코프에 데이터 저장
        HttpSession session = req.getSession(); // Session Scope
        session.setAttribute("scopeName", "sessionScope 값");

        // 리퀘스크 스코프에 데이터 저장
        req.setAttribute("scopeName", "requestScope 값"); // Request Scope
        Member member = new Member("홍길동", "hong");
        req.setAttribute("member", member);

        req.getRequestDispatcher("scope.jsp").forward(req, res);
    }
}