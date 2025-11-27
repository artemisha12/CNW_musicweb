package com.music.model.bean;


import java.sql.Date;
import java.sql.Timestamp;

public class Artist {
    private int artistId;
    private String name;
    private String biography;
    private Date birthday;
    private String avatar;
    private Timestamp createdAt;

    public Artist() {
    }

    public Artist(int artistId, String name, String biography, Date birthday, String avatar, Timestamp createdAt) {
        this.artistId = artistId;
        this.name = name;
        this.biography = biography;
        this.birthday = birthday;
        this.avatar = avatar;
        this.createdAt = createdAt;
    }

    public int getArtistId() { return artistId; }
    public void setArtistId(int artistId) { this.artistId = artistId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBiography() { return biography; }
    public void setBiography(String biography) { this.biography = biography; }

    public Date getBirthday() { return birthday; }
    public void setBirthday(Date birthday) { this.birthday = birthday; }

    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}