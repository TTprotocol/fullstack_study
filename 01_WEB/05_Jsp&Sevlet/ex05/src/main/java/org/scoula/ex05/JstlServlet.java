package org.scoula.ex05;

import org.scoula.ex05.domain.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/jstl_ex")
public class JstlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Member> members = new ArrayList<>();

        // Member 객체 10개 생성 후 리스트에 추가
        for (int i = 0; i < 10; i++) {
            Member member = new Member("홍길동_" + i, "hong_" + i);
            members.add(member);
        }

        // Request scope 에 Member 속성 리스트 저장
        req.setAttribute("members", members);
        req.setAttribute("role", "ADMIN");

        req.setAttribute("today", new Date());

        req.getRequestDispatcher("jstl_ex.jsp").forward(req, res);
    }
}