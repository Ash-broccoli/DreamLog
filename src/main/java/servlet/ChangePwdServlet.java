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

@WebServlet(name = "ChangePwdServlet", value = "/ChangePwdServlet")
public class ChangePwdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        resp.setContentType("text/html");
        boolean wrongPwd = true;
        String username = req.getParameter("username");
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("setPassword");
        String encodedOldPassword = SHA256.getInstantSHA(oldPassword);
        String encodedNewPassword = SHA256.getInstantSHA(newPassword);

        LoginDAO loginDAO = new LoginDAO();

        Login sameUsername = loginDAO.selectByUsername(username);
        if(sameUsername.getPassword().equals(encodedOldPassword)){
            wrongPwd = false;
        }

        if(!wrongPwd){
           sameUsername.setPassword(newPassword);
            System.out.println(sameUsername.getPassword());
           loginDAO.update(sameUsername);
           resp.sendRedirect("login.jsp");
        }else{
            session.setAttribute("wrongPwd", 0);
            resp.sendRedirect("changePwd.jsp");
        }


    }
}
