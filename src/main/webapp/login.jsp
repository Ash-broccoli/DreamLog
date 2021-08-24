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
    <link rel="stylesheet" href="css/login.css">
    <title>☾ Dream Log ☾</title>
</head>
<body>
<div class="fullPageWidth">
    <div class="container">
        <div class="stars"></div>
        <div class="twinkling"></div>
        <div class="card">
            <h2>Log-In</h2>

            <form action="LoginServlet" method="post" accept-charset="utf-8">
                <div class="input-border">
                    <input type="text" class="text" name="username" autofocus required>
                    <label>Username</label>
                    <div class="border"></div>
                </div>

                <div class="input-border">
                    <input type="password" class="text" name="password" required>
                    <label>Password</label>
                    <div class="border"></div>
                </div>
                <%
                    if (session.getAttribute("wrongLogIn") != null && (Integer) session.getAttribute("wrongLogIn") == 1) {
                %>
                <p style="color: red;">Username or password is incorrect!</p>
                <br>
                <%
                        session.setAttribute("wrongLogIn", 0);
                    }
                %>
                <input type="submit" class="btn" value="Log In">
            </form>

        </div>
    </div>
</div>
</body>
</html>
