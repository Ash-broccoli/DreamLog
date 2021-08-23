<%--
  Created by IntelliJ IDEA.
  User: alyss
  Date: 19/08/2021
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Yanone+Kaffeesatz:200' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/style.css">
    <title>☾ Dream Log ☾</title>
</head>
<body>
<%
    if (session.getAttribute("userLoggedIn") == null || !((Boolean) session.getAttribute("userLoggedIn"))) {
        response.sendRedirect("login.jsp");

    }
%>
<div class="fullPageWidth">
    <div class="container">
    <h1>Error some fields were empty!!</h1>
    <h2>Click <a style="text-decoration: underline; cursor: pointer" onclick="window.history.back()">here</a> to go back</h2>
    </div>
</div>
</body>
</html>
