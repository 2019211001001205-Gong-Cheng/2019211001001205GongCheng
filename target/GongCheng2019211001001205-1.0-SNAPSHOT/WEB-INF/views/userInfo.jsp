<%@ page import="com.gongcheng.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 龚成
  Date: 2021/4/11
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
    Cookie [] allCookies = request.getCookies();
    for (Cookie c:allCookies){
        //get one by one
        out.println("<br/>"+c.getName()+"---"+c.getValue());
    }
%>
<%
    User u=(User) session.getAttribute("user");
%>
<table>
    <tr>
        <td>Username:</td><td><%=u.getUsername()%></td>
    </tr>
    <tr>
        <td>Password:</td><td><%=u.getPassword()%></td>
    </tr>
    <tr>
        <td>Email:</td><td><%=u.getEmail()%></td>
    </tr>
    <tr>
        <td>Gender:</td><td><%=u.getGender()%></td>
    </tr>
    <tr>
        <td>Birthdate:</td><td><%=u.getBirthdate()%></td>
    </tr>
    <tr>
        <td><a href="updateUser">Update User</a></td>
    </tr>
</table>
<%@include file="footer.jsp"%>