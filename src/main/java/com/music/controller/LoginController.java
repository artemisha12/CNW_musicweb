package com.music.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import com.music.model.bean.User;
import com.music.service.UserService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
        HttpSession session = req.getSession(false); 
        if (session != null && session.getAttribute("account") != null) {
            resp.sendRedirect("songs");
            return;
        }
        
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String u = req.getParameter("username");
        String p = req.getParameter("password");

        User user = userService.checkLogin(u, p);

        if (user != null) {
         
            HttpSession session = req.getSession();
            session.setAttribute("account", user);
          
            if ("admin".equals(user.getRole())) {
                resp.sendRedirect("songs");
            } else {
                resp.sendRedirect("songs");
            }
        } else {
           
            req.setAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng!");
            req.setAttribute("username", u); 
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}