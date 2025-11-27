package com.music.service;



import com.music.model.bean.Artist;
import com.music.model.bean.Song;
import java.util.ArrayList;
import java.util.List;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SongService {
  
    private static List<Song> mockSongs = new ArrayList<>();
    private static int autoId = 1;

    static {
       
        Artist a1 = new Artist(1, "Sơn Tùng M-TP", "", null, "", null);
        Artist a2 = new Artist(2, "Snoop Dogg", "", null, "", null);
        Artist a3 = new Artist(3, "Taylor Swift", "", null, "", null);

     
        Song s1 = new Song(autoId++, "Hãy Trao Cho Anh", "Pop", 2019, "images/htca.jpg", "Mô tả...", "link_youtube", new Timestamp(System.currentTimeMillis()));
        s1.setArtistNames("Sơn Tùng M-TP, Snoop Dogg");
        s1.getArtists().add(a1);
        s1.getArtists().add(a2);
        mockSongs.add(s1);

        Song s2 = new Song(autoId++, "Love Story", "Country", 2008, "images/ls.jpg", "Mô tả...", "link_youtube", new Timestamp(System.currentTimeMillis()));
        s2.setArtistNames("Taylor Swift");
        s2.getArtists().add(a3);
        mockSongs.add(s2);
    }

    public List<Song> getAllSongs() {
        return mockSongs;
    }

    public Song getSongById(int id) {
        return mockSongs.stream().filter(s -> s.getSongId() == id).findFirst().orElse(null);
    }

    public void addSong(Song song) {
        song.setSongId(autoId++); // Tự tăng ID
        song.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        
        song.setArtistNames("Nghệ sĩ Demo"); 
        mockSongs.add(song);
    }

    public void updateSong(Song newInfo) {
        Song exist = getSongById(newInfo.getSongId());
        if (exist != null) {
            exist.setTitle(newInfo.getTitle());
            exist.setGenre(newInfo.getGenre());
            exist.setYear(newInfo.getYear());
            exist.setLink(newInfo.getLink());
            exist.setDescription(newInfo.getDescription());
        
        }
    }

    public void deleteSong(int id) {
        mockSongs.removeIf(s -> s.getSongId() == id);
    }

    public List<Song> searchSongs(String keyword) {
        String key = keyword.toLowerCase();
        return mockSongs.stream()
                .filter(s -> s.getTitle().toLowerCase().contains(key) || s.getArtistNames().toLowerCase().contains(key))
                .collect(Collectors.toList());
    }
}