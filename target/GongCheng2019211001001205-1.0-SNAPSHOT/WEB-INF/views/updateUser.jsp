<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%
    User u=(User) session.getAttribute("user");
%>
<form action="updateUser" method="post">
    <table>
        <input type="hidden" name="id" value="<%=u.getId()%>">
        <tr> Username: <td><input type="text" name="username" value="<%=u.getUsername()%>"/></td></tr>
        <tr> Password: <td> <input type="password" name="password" value="<%=u.getPassword()%>" style="ime-mode:disabled" name="password" onBlur = "restriction()"/></td></tr>
        <tr> Gender:<td>
                <input type="radio" name="gender" value="Male" <%="Male".equals(u.getGender()) ?"checked":""%>/>Male
                <input type="radio" name="gender" value="Female" <%="Female".equals(u.getGender()) ?"checked":""%>/> Female
            </td>
        </tr>
        <tr>Email: <td><input type="email" name="email" value="<%=u.getEmail()%>"/></td></tr>
        <tr>Birthdate:<td><input type="date" name="birth" value="<%=u.getBirthdate()%>"/></td></tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Save Changes" onclick="return restriction()">
                <input type="reset" value="Reset">
            </td>
        </tr>
    </table>
</form>
<%@include file="footer.jsp"%>
