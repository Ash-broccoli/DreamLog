package servlet;

import database.DAO.DreamDAO;
import models.Dream;
import models.DreamType;
import models.Login;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.FileStore;

@WebServlet(name = "addDreamServlet", value = "/addDreamServlet")
public class AddDreamServlet extends HttpServlet {
    public AddDreamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
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
            Login l = new Login();
            int typeId = Integer.parseInt(stypeId);
            int id = (Integer) session.getAttribute("loginId");
            dt.setTypeID(typeId);
            l.setLoginId(id);

            d.setTitle(title);
            d.setShortDesc(shortDesc);
            d.setTypeID(dt);
            d.setDate(date);
            d.setLongDesc(longDesc);
            d.setLoginID(l);

            new DreamDAO().insert(d);

            response.sendRedirect("index.jsp");
        }

    }

    public void destroy() {
    }
}