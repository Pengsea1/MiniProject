package com.example.demo.repository.model;

public class Category {
    public int cateId;
    public String cateTitle;

    public Category(int cateId, String cateTitle) {
        this.cateId = cateId;
        this.cateTitle = cateTitle;
    }

    public Category(String cateTitle) {
        this.cateTitle = cateTitle;
    }

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "cateId=" + cateId +
                ", cateName='" + cateTitle + '\'' +
                '}';
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getCateTitle() {
        return cateTitle;
    }

    public void setCateTitle(String cateTitle) {
        this.cateTitle = cateTitle;
    }
}
