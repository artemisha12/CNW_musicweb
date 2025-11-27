package com.music.controller;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.music.service.SongService;

@WebServlet("/delete-song")
public class DeleteSongController extends HttpServlet {
    private SongService service = new SongService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if(idStr != null) {
            service.deleteSong(Integer.parseInt(idStr));
        }
        resp.sendRedirect("songs");
    }
}