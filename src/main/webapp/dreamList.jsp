<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Dream" %>
<%@ page import="database.DAO.dreamDAO" %>
<%@ page import="java.util.Date" %><%--
  User: alyss
  Date: 15/08/2021
  Time: 17:47
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<%
    ArrayList<Dream> dlist = new dreamDAO().select();

    %>
<table class="table table-dark table-striped table-hover">
    <thead class="white-header">
    <tr>
        <th scope="col">Title</th>
        <th scope="col">Date</th>
        <th scope="col">Description</th>
        <th scope="col">Type</th>

    </tr>
    </thead>
    <tbody id="list">
    <%
        for (Dream dream : dlist) {
    %>
    <tr>
        <td>
            <% out.print(dream.getTitle());%>
        </td>
        <td>
            <% Date date = dream.getDate();
                out.print(dream.noTimeDate(date));%>
        </td>
        <td>
            <% out.print(dream.getDescription());%>
        </td>
        <td>
            <% out.print(dream.getType().getType());%>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

