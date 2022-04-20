package com.example.demo.model;


public class Post {
    private String id;
    private String title;
    private String category;

    public Post() {
    }

    public Post(String id, String title, String category) {
        this.id = id;
        this.title = title;
        this.category = category;
    }
}