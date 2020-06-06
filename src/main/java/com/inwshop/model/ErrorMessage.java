package com.inwshop.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ErrorMessage {

    private String message;
    private int status;
    private List<FieldErrorsModel> fieldErrors = new ArrayList<>();

    public ErrorMessage(){

    }

    public ErrorMessage(String message, int status, List<FieldErrorsModel> fieldErrors) {
        this.message = message;
        this.status = status;
        this.fieldErrors = fieldErrors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<FieldErrorsModel> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldErrorsModel> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public void addFieldError(FieldErrorsModel fieldError){
        if(!fieldErrors.contains(fieldError))
            fieldErrors.add(fieldError);
    }

    public void clearFieldErrors(){
        fieldErrors.clear();
    }
}

