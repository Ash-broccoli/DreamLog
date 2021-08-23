package servlet;

import database.DAO.LoginDAO;
import login.SHA256;
import models.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="LoginServlet", value="/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        resp.setContentType("text/html");
        boolean isLoggedIn = false;
        int id = 0;
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String encodedPassword = SHA256.getHexString(SHA256.getSHA(password));

         ArrayList<Login> usernames = (ArrayList<Login>) new LoginDAO().select();
         for(Login u : usernames){
             if(username.equals(u.getUsername())){
               id = u.getLoginId();
             }
         }

        if(encodedPassword.equals(new LoginDAO().selectLoginById(id).getPassword())){
            System.out.println("Logged in");
            resp.sendRedirect("index.jsp");
            isLoggedIn = true;
        }
        session.setAttribute("userLoggedIn", isLoggedIn);

        if(!isLoggedIn){
            session.setAttribute("wrongLogIn", 1);
            resp.sendRedirect("login.jsp");
        }

        System.out.println("username = " + username);
        System.out.println("password = " + encodedPassword);
    }
}
