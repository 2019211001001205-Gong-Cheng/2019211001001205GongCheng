<%--
  Created by IntelliJ IDEA.
  User: 龚成
  Date: 2021/4/11
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp" %>
<%@page  contentType="text/html;charset=UTF-8" language="java"%>

<h1>User Info</h1>

<table>
    <tr><td>Username</td><td><%=request.getAttribute("Username")%></td> </tr>
    <td>Password</td><td><%=request.getAttribute("Password")%></td> </tr>
    <td>Email</td> <td><%=request.getAttribute("Email")%></td> </tr>
    <td>Gender</td><td><%=request.getAttribute("Gender")%></td> </tr>
    <td>Birth Date</td> <td><%=request.getAttribute("Birthdate")%></td></tr>
</table>
<%@include file="footer.jsp" %>