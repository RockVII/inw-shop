package com.inwshop.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ValidationErrorMessage {

    private String message;
    private int status;
    private List<FieldError> fieldErrors = new ArrayList<>();

    public ValidationErrorMessage(){}

    public ValidationErrorMessage(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public void addFieldError(FieldError fieldError){
        if(!fieldErrors.contains(fieldError)){
            fieldErrors.add(fieldError);
        }
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

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", fieldErrors=" + fieldErrors +
                '}';
    }
}
