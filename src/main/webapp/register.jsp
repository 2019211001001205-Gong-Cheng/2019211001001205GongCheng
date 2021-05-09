<%--
  Created by IntelliJ IDEA.
  User: 龚成
  Date: 2021/3/31
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="header.jsp" %>
<head>
    <title>register</title>
    <script>
        function isPasswordValid() {
            let password=document.getElementById("password").value;
            if(password.length<8) {
                alert("password lenth less than 8:，"+password.length+"/8");
                document.getElementById("password").style.color="red";
                return false;
            }
            document.getElementById("password").style.color="green";
            return true;
        }
        function isMailValid(){
            let x=document.getElementById("email").value;
            let atpos=x.indexOf("@");
            let dotpos=x.lastIndexOf(".");
            if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length){
                alert("e-mail format wrong");
                document.getElementById("email").style.color="red";
                return false;
            }
            document.getElementById("email").style.color="green";
            return true;
        }
        function isDateValid() {
            let obj=document.getElementById("birth");
            let strDate = obj.value;
            console.log(strDate+"-<")
            let re = /^(\d{4})-(\d{2})-(\d{2})$/;
            if (re.test(strDate))//判断日期格式符合YYYY-MM-DD标准
            {
                let dateElement = new Date(RegExp.$1, parseInt(RegExp.$2, 10) - 1, RegExp.$3);
                if (!((dateElement.getFullYear() == parseInt(RegExp.$1)) && ((dateElement.getMonth() + 1) == parseInt(RegExp.$2, 10)) && (dateElement.getDate() == parseInt(RegExp.$3))))//判断日期逻辑
                {
                    alert("You can only input Date.(YYYY-MM-DD) !");
                    document.getElementById("birth").style.color="red";
                    return false;
                }
            } else {
                alert("You can only input Date.(YYYY-MM-DD)!");
                document.getElementById("birth").style.color="red";
                return false;
            }
            document.getElementById("birth").style.color="green";
            return true;
        }
        function checkAll() {
            if(isDateValid()&&isMailValid()&&isPasswordValid()&&document.getElementById("username").value!=null&&document.getElementById("gender").value!=null) {
                alert("提交成功")
                return true;
            }
            alert("提交失败")
            return false;
        }
    </script>
</head>
<body>
<br>This is my register page
<h1>New User Registration!</h1>
<form action="/register" method="post" onsubmit="checkAll()">
    ID:<input type="text" id="id" name="id"><br>
    Username:<input type="text" id="username" name="username"><br>
    Password:<input type="password" id="password" name="password" onchange="isPasswordValid()"><br>
    E-mail:<input type="email" id="email" name="email" onchange="isMailValid()"><br>
    Gender:<input type="radio" name="gender" value="male">male
    <input type="radio" name="gender" value="female">female<br>
    Birth:<input type="text" id="birth" name="birth" onchange="isDateValid()"><br>
    <input type="submit" value="Register">
</form>
</body>
</html>
<%@ include file="footer.jsp"%>
