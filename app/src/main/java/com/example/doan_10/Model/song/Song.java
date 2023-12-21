package com.example.doan_10.Model.song;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Song implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("releaseDate")
    private String releaseDate;
    @SerializedName("duration")
    private String duration;
    @SerializedName("avatar")
    private String avatar;
    @SerializedName("genre")
    private String genre;
    @SerializedName("nameArtist")
    private String nameArtist;
    @SerializedName("listPlaylist")
    private List<Integer> listPlaylist;
    @SerializedName("listAlbum")
    private List<String> listAlbum;
    @SerializedName("urlMusic")
    private String urlMusic;
    public Song(int id, String title, String releaseDate, String duration, String avatar, String genre, String nameArtist, List<Integer> listPlaylist, List<String> listAlbum, String urlMusic) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.avatar = avatar;
        this.genre = genre;
        this.nameArtist = nameArtist;
        this.listPlaylist = listPlaylist;
        this.listAlbum = listAlbum;
        this.urlMusic = urlMusic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    public List<Integer> getListPlaylist() {
        return listPlaylist;
    }

    public void setListPlaylist(List<Integer> listPlaylist) {
        this.listPlaylist = listPlaylist;
    }

    public List<String> getListAlbum() {
        return listAlbum;
    }

    public void setListAlbum(List<String> listAlbum) {
        this.listAlbum = listAlbum;
    }

    public String getUrlMusic() {
        return urlMusic;
    }

    public void setUrlMusic(String urlMusic) {
        this.urlMusic = urlMusic;
    }
}
