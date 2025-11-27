package com.music.model.bean;


import java.util.ArrayList;
import java.util.List;

public class Album {
    private int albumId;
    private String title;
    private int releaseYear;
    private String cover;
    private String description;

    private List<Song> songs = new ArrayList<>();

    public Album() {
    }

    public Album(int albumId, String title, int releaseYear, String cover, String description) {
        this.albumId = albumId;
        this.title = title;
        this.releaseYear = releaseYear;
        this.cover = cover;
        this.description = description;
    }

    public int getAlbumId() { return albumId; }
    public void setAlbumId(int albumId) { this.albumId = albumId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getReleaseYear() { return releaseYear; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }

    public String getCover() { return cover; }
    public void setCover(String cover) { this.cover = cover; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<Song> getSongs() { return songs; }
    public void setSongs(List<Song> songs) { this.songs = songs; }
}