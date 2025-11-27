package com.music.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.music.service.UserService;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    private UserService userService = new UserService();

  
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String u = req.getParameter("username");
        String p = req.getParameter("password");
        String pConfirm = req.getParameter("confirm_password");

        if (!p.equals(pConfirm)) {
            req.setAttribute("error", "Mật khẩu xác nhận không khớp!");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }
        if (userService.isUsernameExist(u)) {
            req.setAttribute("error", "Tên tài khoản đã được sử dụng!");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }
        boolean success = userService.register(u, p);
        if (success) {
           
            req.setAttribute("mess", "Đăng ký thành công! Vui lòng đăng nhập.");
            req.getRequestDispatcher("login.jsp").forward(req, resp); 
        
        } else {
            req.setAttribute("error", "Đăng ký thất bại, vui lòng thử lại.");
            req.getRequestDispatcher("vregister.jsp").forward(req, resp);
        }
    }
}