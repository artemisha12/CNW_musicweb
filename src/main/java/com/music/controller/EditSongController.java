package com.music.controller;


//import dao.SongDAO;
//import model.Song;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.music.model.bean.Song;
import com.music.service.SongService;

@WebServlet("/edit-song")
public class EditSongController extends HttpServlet {
    private SongService service = new SongService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if(idStr != null) {
            int id = Integer.parseInt(idStr);
            Song s = service.getSongById(id);
            req.setAttribute("song", s);
            req.setAttribute("isEdit", true); 
            req.getRequestDispatcher("song-form.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("songs");
        }
    }

    // POST: Cập nhật thông tin
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String genre = req.getParameter("genre");
        int year = Integer.parseInt(req.getParameter("year"));
        String link = req.getParameter("link");
        String desc = req.getParameter("description");

        Song s = new Song();
        s.setSongId(id);
        s.setTitle(title);
        s.setGenre(genre);
        s.setYear(year);
        s.setLink(link);
        s.setDescription(desc);

        service.updateSong(s);

        resp.sendRedirect("songs");
    }
}