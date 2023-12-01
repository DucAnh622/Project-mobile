package com.example.doan_10.Model;

public class Artist {
    private int ImageId;
    private String name;

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public Artist (int ImageId, String name) {
        this.ImageId = ImageId;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
