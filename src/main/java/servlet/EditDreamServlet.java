package servlet;

import database.DAO.DreamDAO;
import models.Dream;
import models.DreamType;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "editDreamServlet", value = "/editDreamServlet")
public class EditDreamServlet extends HttpServlet {
    public EditDreamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String sdreamId = request.getParameter("dreamId");
        String title = request.getParameter("title");
        String shortDesc = request.getParameter("shortDesc");
        String stypeId = request.getParameter("type");
        String date = request.getParameter("date");
        String longDesc = request.getParameter("longDesc");
        boolean emptyField = false;

        if (title.equals("")) {
            emptyField = true;
        }
        if (shortDesc.equals("")) {
            emptyField = true;
        }
        if (stypeId.equals("")) {
            emptyField = true;
        }
        if (date.equals("")) {
            emptyField = true;
        }
        if (longDesc.equals("")) {
            emptyField = true;
        }

        if (emptyField) {
            response.sendRedirect("error.jsp");
        } else {

            Dream d = new Dream();
            DreamType dt = new DreamType();
            int dreamId = Integer.parseInt(sdreamId);
            int typeId = Integer.parseInt(stypeId);
            d.setDreamID(dreamId);
            dt.setTypeID(typeId);

            d.setTitle(title);
            d.setShortDesc(shortDesc);
            d.setTypeID(dt);
            d.setDate(date);
            d.setLongDesc(longDesc);

            new DreamDAO().update(d);

            response.sendRedirect("dreamInfo.jsp?dreamId=" + d.getDreamID());
        }

    }

    public void destroy() {
    }
}

