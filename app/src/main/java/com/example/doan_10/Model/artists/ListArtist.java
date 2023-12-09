package com.example.doan_10.Model.artists;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListArtist {
    @SerializedName("total")
    private int total;
    @SerializedName("listArtist")
    private List<Artist> listArtist;

    public ListArtist(int total, List<Artist> listArtist) {
        this.total = total;
        this.listArtist = listArtist;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Artist> getListArtist() {
        return listArtist;
    }

    public void setListArtist(List<Artist> listArtist) {
        this.listArtist = listArtist;
    }
}
