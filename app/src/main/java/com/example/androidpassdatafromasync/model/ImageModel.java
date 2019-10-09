package com.example.androidpassdatafromasync.model;

public class ImageModel {
    private String author;
    private String image;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ImageModel(String author, String image) {
        this.author = author;
        this.image = image;
    }
}
