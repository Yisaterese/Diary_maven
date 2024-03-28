package com.africa.semicolon.diary.data.models;


public class Entry {
    private String body;
    private String title;
    private String author;
    private int id;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "A"+ author+"body"+body+"title"+title;
    }
}


