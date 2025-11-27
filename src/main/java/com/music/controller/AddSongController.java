package com.music.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.music.model.bean.Song;
import com.music.service.SongService;


@WebServlet("/add-song")
public class AddSongController extends HttpServlet {
    private SongService service = new SongService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     
        req.getRequestDispatcher("song-form.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String title = req.getParameter("title");
        String genre = req.getParameter("genre");
        int year = Integer.parseInt(req.getParameter("year"));
        String link = req.getParameter("link");
        String desc = req.getParameter("description");
        
    
        Song newSong = new Song();
        newSong.setTitle(title);
        newSong.setGenre(genre);
        newSong.setYear(year);
        newSong.setLink(link);
        newSong.setDescription(desc);
        newSong.setThumbnail("images/nvd.jpg");

        service.addSong(newSong);

        resp.sendRedirect("songs");
    }
}