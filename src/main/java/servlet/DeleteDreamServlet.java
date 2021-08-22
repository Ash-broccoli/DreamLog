package servlet;

import database.DAO.DreamDAO;
import models.Dream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteDreamServlet", value = "/deleteDreamServlet")
public class DeleteDreamServlet extends HttpServlet {
    public DeleteDreamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int dreamId = Integer.parseInt(request.getParameter("dreamId"));
        Dream dream = new DreamDAO().selectWithId(dreamId);
        new DreamDAO().delete(dream);
        System.out.println("Dream was deleted");
        response.sendRedirect("deleteDream.jsp");
    }

    public void destroy() {
    }
}