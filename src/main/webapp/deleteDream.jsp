<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <script src="js/dreamData.js"></script>
    <script src="js/ajax_engine.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Yanone+Kaffeesatz:200' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/style.css">
    <title>☾ Dream Log ☾</title>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            loadData("all", "delete");

        });

        function confirmDelete() {
            var r = confirm("Are you sure you want to delete this dream?");
            if (r === true) {
                document.getElementById("deleteForm").submit();
            } else {
                window.location = "deleteDream.jsp";
            }
        }
    </script>
</head>
<body <%
    String deleteId = request.getParameter("dreamId");
    if (request.getParameter("confirm") != null) {
%> onload=confirmDelete();<%
    }
%>>
<%
    if (session.getAttribute("userLoggedIn") == null || !((Boolean) session.getAttribute("userLoggedIn"))) {
        response.sendRedirect("login.jsp");

    }
%>
<div class="fullPageWidth">
    <header class="header">
    </header>
    <div class="container">
        <div class="stars"></div>
        <div class="twinkling"></div>
        <nav class="navbar navbar-expand-lg navbar-dark ">
            <a class="navbar-brand" href="index.jsp">Home ✦</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-item nav-link " href="dreams.jsp">Dreams |</a>
                    <a class="nav-item nav-link" href="addDream.jsp">Add Dream |</a>
                    <a class="nav-item nav-link active" href="deleteDream.jsp">Delete Dream<span class="sr-only">(current)</span></a>
                </div>
            </div>
        </nav>
        <hr class="navLine"/>

        <br>
        <h1>✧Delete Dream</h1>
        <br>

        <div id="list">
            <h2>Dreams are being loaded <small><img alt="rocketloader" class="loader" width="200" height="auto"
                                                    id="loading"
                                                    src="img/loading.gif"></small>
            </h2>
        </div>
        <form id="deleteForm" method="GET" action="deleteDreamServlet">
            <input type="hidden" name="dreamId" value="<%out.print(deleteId);%>">
        </form>
    </div>
</div>
</body>

</html>