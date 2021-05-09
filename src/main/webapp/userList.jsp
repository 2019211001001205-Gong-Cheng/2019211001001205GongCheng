<%--
  Created by IntelliJ IDEA.
  User: 龚成
  Date: 2021/4/11
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp" %>
<h2>User List</h2>
<table>
    <tr><td>ID</td><td>Username</td><td>Password</td><td>Email</td><td>Gender</td><td>Birthday</td></tr>
    <%@page import="java.sql.*" %>
    <%
        ResultSet rs = (ResultSet)request.getAttribute("rsname");
        while(rs.next()){
            System.out.println("<tr><td>"+rs.getString("id")+"</td><td>"+rs.getString("name")+"</td><td>"
                    +rs.getString("password")+"</td><td>"+rs.getString("email")+"</td><td>"
                    +rs.getString("gender")+"</td><td>"+rs.getString("birth")+"</td></tr>");
        }
    %>

</table>

<%@include file="footer.jsp" %>
