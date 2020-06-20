package com.inwshop.model;

import java.io.File;

public class ShopModel {

    String name;
    String imagePath;

    public ShopModel(){}

    public ShopModel(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
