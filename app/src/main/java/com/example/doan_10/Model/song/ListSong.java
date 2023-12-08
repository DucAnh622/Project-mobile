package com.example.doan_10.Model.song;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListSong {
    @SerializedName("total")
    private int total;
    @SerializedName("list_song")
    private List<Song> list_song;

    public ListSong(int total, List<Song> list_song) {
        this.total = total;
        this.list_song = list_song;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Song> getList_song() {
        return list_song;
    }

    public void setList_song(List<Song> list_song) {
        this.list_song = list_song;
    }
}
