<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 25. 6. 4.
  Time: 오후 3:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
</head>
<body>
    username 값: <%=request.getAttribute("username") %><br>
    useraddress 값: <%=request.getAttribute("useraddress") %><br>
</body>
</html>
