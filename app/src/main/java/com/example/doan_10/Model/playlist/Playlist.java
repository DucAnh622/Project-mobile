package com.example.doan_10.Model.playlist;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Playlist {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("userName")
    private String userName;
    @SerializedName("listSong")
    private List<String> listSong;

    public Playlist(int id, String name, String userName, List<String> listSong) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.listSong = listSong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getListSong() {
        return listSong;
    }

    public void setListSong(List<String> listSong) {
        this.listSong = listSong;
    }
}
