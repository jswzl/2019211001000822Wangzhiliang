<%--
  Created by IntelliJ IDEA.
  User: 王志良
  Date: 2021-04-04
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>

<h1>Login</h1>

<form  id="login" method="post" action="/login">
    <label for="username">username</label>
    <input id="username" name="username" type="text"> <br/>

    <label for="username">password</label>
    <input id="password" name="password" type="password"> <br/>

    <input class="submit" type="submit" value="login">
</form>

<%@include file="footer.jsp"%>
</body>
</html>
