package com.example.doan_10.Model;

import android.provider.ContactsContract;

public class Song {
    private int ImageId;
    private String nameSong;
    private String singer;
    private Boolean check;
    public Song (int ImageId, String nameSong, String singer, Boolean check) {
        this.ImageId = ImageId;
        this.nameSong = nameSong;
        this.singer = singer;
        this.check = check;
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

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
