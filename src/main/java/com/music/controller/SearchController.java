package com.music.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

import com.music.model.bean.Song;
import com.music.service.SongService;

@WebServlet("/search")
public class SearchController extends HttpServlet {
    private SongService service = new SongService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String keyword = req.getParameter("q"); 
        
        if (keyword != null && !keyword.isEmpty()) {
            req.setAttribute("listSongs", service.searchSongs(keyword));
            req.setAttribute("searchKeyword", keyword); 
        } else {
            req.setAttribute("listSongs", service.getAllSongs());
        }
        
        req.getRequestDispatcher("song-list.jsp").forward(req, resp);
    }
}