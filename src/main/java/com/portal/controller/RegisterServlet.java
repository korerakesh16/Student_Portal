package com.portal.controller;

import com.portal.dao.UserDAO;
import com.portal.model.User;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;


public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        user.setRole(req.getParameter("role"));

        
        if (new UserDAO().registerUser(user)) {
            resp.sendRedirect("jsp/login.jsp");
        } else {
            resp.getWriter().println("Registration failed.");
        }
    }
}
