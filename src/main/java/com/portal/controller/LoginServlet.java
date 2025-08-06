package com.portal.controller;
import com.portal.dao.UserDAO;
import com.portal.model.User;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password"); 
        
        User user = new UserDAO().loginUser(email, password);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("jsp/home.jsp");
        } else {
            resp.getWriter().println("Invalid email or password.");
        }
    }  
}


