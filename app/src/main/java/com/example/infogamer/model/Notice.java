package com.example.infogamer.model;

public class Notice {
    public String author;
    public String title;
    public String description;
    public String photo;
    public String date;
    public String url;
    public String content;

    public Notice(){};

    public Notice(String author, String title, String description, String photo, String date,String url,String content) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.date = date;
        this.url = url;
        this.content = content;
    }
}
