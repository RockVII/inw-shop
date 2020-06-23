package com.inwshop.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class ImageModel {

    private MultipartFile image;
    private String name;

    public  ImageModel(){}

    public ImageModel(MultipartFile image, String name) {
        this.image = image;
        this.name = name;
    }

//    public ImageModel(String name){
//        this.name = name;
//    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
