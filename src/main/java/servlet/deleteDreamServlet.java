package servlet;

import database.DAO.dreamDAO;
import models.Dream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "deleteDreamServlet", value = "/deleteDreamServlet")
public class deleteDreamServlet extends HttpServlet {
    public deleteDreamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int dreamId = Integer.parseInt(request.getParameter("dreamId"));
        Dream dream = new dreamDAO().selectWithId(dreamId);
        new dreamDAO().delete(dream);
        System.out.println("Dream was deleted");
        response.sendRedirect("deleteDream.jsp");
    }

    public void destroy() {
    }
}