package com.example.doan_10.Model.artists;

import com.google.gson.annotations.SerializedName;

public class Artist {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("avatar")
    private String avatar;

    public Artist(int id, String name, String avatar) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
