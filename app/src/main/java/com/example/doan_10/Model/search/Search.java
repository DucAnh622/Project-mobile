package com.example.doan_10.Model.search;

import com.example.doan_10.Model.artists.Artist;
import com.example.doan_10.Model.song.Song;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Search {
    @SerializedName("total")
    private int total;
    @SerializedName("artists")
    private List<Artist> artists;
    @SerializedName("songs")
    private List<Song> songs;

    public Search(int total, List<Artist> artists, List<Song> songs) {
        this.total = total;
        this.artists = artists;
        this.songs = songs;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
