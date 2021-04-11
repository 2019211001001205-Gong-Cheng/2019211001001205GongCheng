<%--
  Created by IntelliJ IDEA.
  User: 龚成
  Date: 2021/4/4
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp" %>
<h1>Login </h1> <br>
<%
    if(request.getAttribute("msg") != null)
    {
        out.println("<h3 style = 'color:red'>"+request.getAttribute("msg")+"</h3>");
    }
%>

<form method="post" action="${pageContext.request.contextPath}/login">
    <p>Username:<input type="text" name="name"/></p>

    <p>Password:<input type="password" name="password"/></p>
    <input type="submit" value="Login"/>
</form>
<%@include file="footer.jsp" %>