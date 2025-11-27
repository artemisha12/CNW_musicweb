package com.music.model.bean;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Song {
   
    private int songId;
    private String title;
    private String genre;
    private int year;
    private String thumbnail;
    private String description;
    private String link;
    private Timestamp createdAt;

   
    private List<Artist> artists = new ArrayList<>();
    private String artistNames; 

    public Song() {
    }

    public Song(int songId, String title, String genre, int year, String thumbnail, String description, String link, Timestamp createdAt) {
        this.songId = songId;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.thumbnail = thumbnail;
        this.description = description;
        this.link = link;
        this.createdAt = createdAt;
    }

    // Getter và Setter
    public int getSongId() { return songId; }
    public void setSongId(int songId) { this.songId = songId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getThumbnail() { return thumbnail; }
    public void setThumbnail(String thumbnail) { this.thumbnail = thumbnail; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

    // Getter/Setter cho thuộc tính phụ
    public List<Artist> getArtists() { return artists; }
    public void setArtists(List<Artist> artists) { this.artists = artists; }

    public String getArtistNames() { return artistNames; }
    public void setArtistNames(String artistNames) { this.artistNames = artistNames; }
}