package com.inwshop.exception;

import com.inwshop.model.ErrorMessage;

public class BadRequestRegisterExeception extends IllegalArgumentException{

    private String message;
    private ErrorMessage errorMessage;

    public BadRequestRegisterExeception(){

    }

    public BadRequestRegisterExeception(String message){
        super(message);

    }
    public BadRequestRegisterExeception(String message, ErrorMessage errorMessage){
        this.message = message;
        this.errorMessage= errorMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }
}
