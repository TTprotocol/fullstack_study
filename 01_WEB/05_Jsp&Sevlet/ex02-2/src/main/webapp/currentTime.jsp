<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 25. 5. 29.
  Time: 오전 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>스크립트릿 실습</title>
</head>
<body>
    <h1>현재 날짜 출력 실습</h1>
    <%
        Date d = new Date();
        Date d2 = null; // d2가 null이다. => 값이 없으니, 아무것도 출력되지 않기를 원함. => 그러나 실제로는 null이 출력됨.
    %>
    현재 날짜 : <%= d %>, <%= d2 %>
</body>
</html>
