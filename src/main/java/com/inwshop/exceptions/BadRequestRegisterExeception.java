package com.inwshop.exceptions;

import com.inwshop.DTO.ErrorDTO;
import com.inwshop.model.ErrorMessage;

public class BadRequestRegisterExeception extends IllegalArgumentException{

    private String message;
    private ErrorDTO errorMessage;

    public BadRequestRegisterExeception(){

    }

    public BadRequestRegisterExeception(String message){
        super(message);

    }
    public BadRequestRegisterExeception(String message, ErrorDTO errorMessage){
        this.message = message;
        this.errorMessage= errorMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorDTO getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(ErrorDTO errorMessage) {
        this.errorMessage = errorMessage;
    }
}
