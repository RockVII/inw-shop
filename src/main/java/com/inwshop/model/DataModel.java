package com.inwshop.model;

public class DataModel {
    private String message;

    public DataModel() {
    }

    public DataModel(String meesage) {
        this.message = meesage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
