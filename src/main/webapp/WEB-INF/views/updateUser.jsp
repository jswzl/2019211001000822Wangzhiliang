<%--
  Created by IntelliJ IDEA.
  User: 王志良
  Date: 2021-04-21
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<%
    User u= (User) session.getAttribute("user");
%>

<form  id="updateUserForm" method="post" action="updateUser">

    <legend>Update Info</legend>

    <input type="hidden" name="id" value="<%=u.getId()%>">
    <label for="username">username</label>
    <input id="username" name="username" type="text" value="<%=u.getUsername()%>">

    <label>gender</label>
    <input id="gender_m" name="gender" value="boy" type="radio" <%="boy".equals(u.getGender())?"checked":""%>>boy
    <input id="gender_f" name="gender" value="girl" type="radio" <%="girl".equals(u.getGender())?"checked":""%>>girl

    <label for="password">password</label>
    <input id="password" name="password" type="password" value="<%=u.getPassword()%>">

    <label for="email">Email</label>
    <input id="email" name="email" type="email" value="<%=u.getEmail()%>">

    <label for="birthday">Birthday</label>
    <input id="birthday" name="birthday" type="text" value="<%=u.getBirthday()%>">

    <input class="submit" type="submit" value="Save Changes">
</form>


<%@include file="footer.jsp"%>
