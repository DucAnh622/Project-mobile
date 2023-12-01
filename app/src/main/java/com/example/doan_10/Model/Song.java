package com.example.doan_10.Model;

import android.provider.ContactsContract;

public class Song {
    private int ImageId;
    private String nameSong;
    private String singer;

    public Song (int ImageId, String nameSong, String singer) {
        this.ImageId = ImageId;
        this.nameSong = nameSong;
        this.singer = singer;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
