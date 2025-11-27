package com.music.controller;


//import dao.SongDAO;
//import model.Song;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.music.model.bean.Song;
import com.music.service.SongService;


@WebServlet("/song-detail")
public class SongDetailController extends HttpServlet {
    private SongService service = new SongService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Song song = service.getSongById(id);

            if (song != null) {
                req.setAttribute("song", song);
                req.getRequestDispatcher("views/song-detail.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("songs");             }
        } catch (NumberFormatException e) {
            resp.sendRedirect("songs");
        }
    }
}