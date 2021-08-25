<%@ page import="models.DreamType" %>
<%@ page import="database.DAO.DreamTypeDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Dream" %>
<%@ page import="database.DAO.DreamDAO" %><%--
  Created by IntelliJ IDEA.
  User: alyss
  Date: 18/08/2021
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="js/dreamData.js"></script>
    <script src="js/ajax_engine.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Yanone+Kaffeesatz:200' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/style.css">
    <title>☾ Dream Log ☾</title>
</head>
<body>
<%
    if (session.getAttribute("loginId") == null) {
        response.sendRedirect("login.jsp");
    }else{
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
                    <a class="nav-item nav-link active" href="dreams.jsp">Dreams <span
                            class="sr-only">(current)</span>|</a>
                    <a class="nav-item nav-link " href="addDream.jsp">Add Dream |</a>
                    <a class="nav-item nav-link " href="deleteDream.jsp">Delete Dream |</a>
                    <a class="nav-item nav-link" id="logout" href="LogoutServlet">Log out</a>
                </div>
            </div>
        </nav>
        <hr class="navLine"/>
        <h1>✧In depth Dream</h1>
        <%
            String sDreamId = request.getParameter("editId");
            int dreamId = Integer.parseInt(sDreamId);
            Dream d = new DreamDAO().selectWithId(dreamId);
            String title = d.getTitle();
            String shortDesc = d.getShortDesc();
            String date = d.getDate();
            String type = d.getTypeID().getType();
            String longDesc = d.getLongDesc();

            int userId = d.getLoginID().getLoginId();
            int loggedInId = (Integer) session.getAttribute("loginId");
            if( userId != loggedInId){
                response.sendRedirect("index.jsp");
            }
        %>
        <form action="editDreamServlet" method="get" accept-charset="UTF-8">
            <div class="row">
                <input type="hidden" name="dreamId" value="<%out.print(dreamId);%>">
                <div class="form-group col-md-6">
                    <label for="title">Title</label>
                    <input type="text" class="form-control" id="title" name="title" value="<%out.print(title);%>"
                           autofocus>
                </div>
                <div class="form-group col-md-6">
                    <label for="type">Type</label>
                    <select class="form-control" id="type" name="type" required>
                        <option value="" selected disabled hidden>Select a type</option>
                        <%
                            ArrayList<DreamType> typeList = new DreamTypeDAO().select();
                            for (DreamType t : typeList) {
                                if (t.getType().equals(type)) {%>
                        <option selected style="color:black" value="<%out.print(t.getTypeID());%>"><%
                            out.print(t.getType());%></option>
                        <% } else {
                        %>
                        <option style="color: black;" value="<%out.print(t.getTypeID());%>"><%
                            out.print(t.getType());%></option>
                        <%
                                }
                            }
                        %>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="shortDesc">Short Description</label>
                    <input type="text" class="form-control" id="shortDesc" name="shortDesc"
                           value="<%out.print(shortDesc);%>">
                </div>
                <div class="form-group col-md-6">
                    <label for="date">Date</label>
                    <input type="date" class="form-control" id="date" name="date" value="<%out.print(date);%>"
                    >
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="longDesc">Long Description</label>
                    <textarea class="form-control" id="longDesc" name="longDesc" rows="10"
                              cols="25"><%out.print(longDesc);%></textarea>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-9">
                    <button class="btn btn-secondary" type="submit">Done</button>
                </div>
            </div>
        </form>
    </div>
</div>
<%}%>
</body>
</html>
