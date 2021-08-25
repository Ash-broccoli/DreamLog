package servlet;

import database.DAO.LoginDAO;
import models.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AddUserServlet", value = "/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        resp.setContentType("text/html");
        String username = req.getParameter("setUsername");
        String password = req.getParameter("setPassword");
        LoginDAO loginDAO = new LoginDAO();

        Login sameUsername = loginDAO.selectByUsername(username);
        if (sameUsername == null) {
            Login l = new Login();
            l.setUsername(username);
            l.setPassword(password);
            loginDAO.insert(l);

            System.out.println("username = " + username);
            System.out.println("password = " + password);
            resp.sendRedirect("login.jsp");
        } else {

            session.setAttribute("userExists", 1);
            resp.sendRedirect("register.jsp");
        }

    }

}

