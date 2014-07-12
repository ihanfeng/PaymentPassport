<%--
  Created by IntelliJ IDEA.
  User: chenhf
  Date: 2014/7/5
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
测试写入cookie
<%


    Cookie cookie = new Cookie("userName", "chf");
    cookie.setDomain(".portal.cecpay.com");
    cookie.setPath("/users");

    response.addCookie(cookie);


%>
</body>
</html>
