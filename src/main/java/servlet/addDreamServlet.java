package servlet;

import database.DAO.dreamDAO;
import models.Dream;
import models.DreamType;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "addDreamServlet", value = "/addDreamServlet")
public class addDreamServlet extends HttpServlet {
    public addDreamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

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

        if(emptyField){
            response.sendRedirect("error.jsp");
        }else {

            Dream d = new Dream();
            DreamType dt = new DreamType();
            Date parsedDate = null;
            int typeId = Integer.parseInt(stypeId);
            dt.setTypeID(typeId);
            try {
                parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            } catch (ParseException e) {
                System.err.println("Parse was unsuccessful!");
                e.printStackTrace();
            }
            d.setTitle(title);
            d.setShortDesc(shortDesc);
            d.setTypeID(dt);
            d.setDate(parsedDate);
            d.setLongDesc(longDesc);

            new dreamDAO().insert(d);

            response.sendRedirect("index.jsp");
        }

    }

    public void destroy() {
    }
}