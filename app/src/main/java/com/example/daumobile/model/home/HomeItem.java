package com.example.daumobile.model.home;

import androidx.annotation.DrawableRes;

import java.util.UUID;

public class HomeItem {
    private String id = UUID.randomUUID().toString();
    private String name;
    private @DrawableRes int image;

    public HomeItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public HomeItem(String name, int image) {
        this.name = name;
        this.image = image;
    }
}
