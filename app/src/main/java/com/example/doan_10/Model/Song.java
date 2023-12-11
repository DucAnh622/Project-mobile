package com.example.doan_10.Model;

import android.provider.ContactsContract;

import java.io.Serializable;

public class Song implements Serializable {
    private int ImageId;
    private String nameSong;
    private String singer;
    private int file;
    private Boolean check;
    public Song (int ImageId, String nameSong, String singer, int file,Boolean check) {
        this.ImageId = ImageId;
        this.nameSong = nameSong;
        this.singer = singer;
        this.file = file;
        this.check = check;
    }
    public int getFile() {
        return file;
    }
    public void setFile(int file) {
        this.file = file;
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
