<%--
  Created by IntelliJ IDEA.
  User: 王志良
  Date: 2021-03-09
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello Jsp</title>
</head>
<body>
    <%@include file="header.jsp"%>
    <h1>Welcome to my home page!</h1>
    <br/>
    <form method="get" target="_blank" action="/search">
        <input type="text" name="txt" size=30/>
        <select name="search">
            <option value="baidu">Baidu</option>
            <option value="bing">Bing</option>
            <option value="google">Google</option>
        </select>
        <input type="submit" value="Search"/>
    </form>
    <a href="hello">My First Servlet -wekek2</a> <br/>
    <a href="register.jsp">Register Page -week3</a> <br/>
    <a href="config">Config parameter -week4</a> <br/>
    <a href="index.jsp">include -week5</a><br/>
    <a href="login.jsp">Login page -week5</a>
    <%@include file="footer.jsp"%>
</body>
</html>
