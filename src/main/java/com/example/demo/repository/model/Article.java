package com.example.demo.repository.model;

import javax.validation.constraints.*;

public class Article {

    public Integer id;
    @NotBlank
    public String title;
    @NotBlank
    public String author;

    public Category category;
    public String des;
    public String img;

    public Article() {

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Article(Integer id, String title, String author, Category category, String des, String img) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.des = des;
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category=" + category +
                ", des='" + des + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public String getDes() {
        return des;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Article(Integer id, String title, String author, String des, String img) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.des = des;
        this.img = img;
    }

}
