package servlets;

import java.io.*;
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



    }

    public void destroy() {
    }
}