<%--
  Created by IntelliJ IDEA.
  User: alyss
  Date: 22/08/2021
  Time: 12:18
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
<div class="fullPageWidth">
    <div class="container">
        <div class="stars"></div>
        <div class="twinkling"></div>
        <div class="card">
            <h2>Register</h2>
            <% if(session.getAttribute("userExists") != null){
                out.print("<p class=\"text-danger\">This username is unavailable!</p>");

            }%>
            <form action="AddUserServlet" method="post" accept-charset="utf-8">
                <div class="input-border">
                    <input type="text" class="text" name="setUsername" autofocus required>
                    <label>Set Username</label>
                    <div class="border"></div>
                </div>

                <div class="input-border">
                    <input type="password" class="text" name="setPassword" required>
                    <label>Set Password</label>
                    <div class="border"></div>
                </div>

                <div class="input-border">
                    <input type="password" class="text" name="confPassword" required>
                    <label>Confirm Password</label>
                    <div class="border"></div>
                </div>
                <input type="submit" class="btn" value="Register">
            </form>
        </div>
    </div>
</div>
</body>
</html>
