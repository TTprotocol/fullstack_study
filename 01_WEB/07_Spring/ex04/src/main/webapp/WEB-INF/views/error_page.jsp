<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" import="java.util.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <%-- out : jsp 출력용 태그. 안에 있는 내용을 출력해 주겠다는 의미이다.  --%>
    <h4><c:out value="${exception.getMessage()}"></c:out></h4>

    <ul>
        <%-- 예외의 전체 스택 트레이스를 순회하며 출력 --%>
        <c:forEach items="${exception.getStackTrace() }" var="stack">
            <li><c:out value="${stack}"></c:out></li>
        </c:forEach>
    </ul>
</body>
</html>