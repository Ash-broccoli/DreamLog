<%@ page import="database.DAO.LoginDAO" %>
<%@ page import="models.Login" %><%--
  Created by IntelliJ IDEA.
  User: alyss
  Date: 25/08/2021
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="css/login.css">
    <title>☾ Dream Log ☾</title>
</head>
<body>
<%
    if (session.getAttribute("loginId") == null) {
        response.sendRedirect("login.jsp");
    } else {
%>
<div class="fullPageWidth">
    <div class="container">
        <div class="stars"></div>
        <div class="twinkling"></div>
        <div class="card">
            <h2>Change password</h2>
            <% if (session.getAttribute("wrongPwd") != null) {
                out.print("<p class=\"text-danger\">Old password is incorrect!</p>");
                }
            int id = (Integer) session.getAttribute("loginId");
            Login l = new LoginDAO().selectLoginById(id);
            %>
            <form action="ChangePwdServlet" method="post" accept-charset="utf-8">
                <input type="hidden" name="username" value="<%out.print(l.getUsername());%>">
                <div class="input-border">
                    <input type="password" class="text" name="oldPassword" autofocus required>
                    <label>Old password</label>
                    <div class="border"></div>
                </div>

                <div class="input-border">
                    <input type="password" class="text" name="setPassword" id="setPassword" required>
                    <label>New Password</label>
                    <div class="border"></div>
                </div>

                <div class="input-border">
                    <input type="password" oninput="comparePass()" class="text" name="confPassword" id="password2"
                           required>
                    <label>Confirm Password</label>
                    <p class="text-danger" id="warning"></p>
                    <div class="border"></div>
                </div>
                <input type="submit" id="submit" class="btn" value="Change">
            </form>
        </div>
    </div>
</div>
<script>
    function comparePass() {
        let password = document.getElementById("setPassword").value;
        let password2 = document.getElementById("password2").value;

        if (password !== password2) {
            document.getElementById("warning").innerHTML = "Passwords aren't identical!";
            document.getElementById("submit").disabled = true;
        } else {
            document.getElementById("warning").innerHTML = "";
            document.getElementById("submit").disabled = false;
        }
    }

</script>
<%}%>
</body>
</html>

