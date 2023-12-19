package com.example.doan_10.Model;

public class Playlist {
    private String name;
    private boolean check;

    public Playlist (String name, Boolean check) {
        this.name = name;
        this.check = check;
    }

    public String getName() {
        return name;
    }

    public boolean getCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public void setName(String name) {
        this.name = name;
    }
}
