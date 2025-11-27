package com.music.controller;


//import dao.SongDAO;
//import model.Song;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

import com.music.model.bean.Song;
import com.music.service.SongService;


@WebServlet("/songs")
public class SongController extends HttpServlet {
    private SongService service = new SongService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        req.setAttribute("listSongs", service.getAllSongs());
        req.getRequestDispatcher("song-list.jsp").forward(req, resp);
    }
}