package com.inwshop.controller;

import com.inwshop.exception.BadRequestRegisterExeception;
import com.inwshop.model.ErrorMessage;
import com.inwshop.model.ValidationErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionController {

    @Autowired
    private ValidationErrorMessage validationErrorMessage;

    @Autowired
    private ErrorMessage errorMessage;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorMessage> error(MethodArgumentNotValidException ex){
        BindingResult br =  ex.getBindingResult();
        List<FieldError> fieldErrors = br.getFieldErrors();
        validationErrorMessage.setStatus(HttpStatus.BAD_REQUEST.value());
        validationErrorMessage.setMessage("Datos erróneos");
        for(FieldError fr: fieldErrors){
            if(fr.getField().equals("phone"))
                validationErrorMessage.addFieldError(new FieldError(fr.getObjectName(),fr.getField(),"El número de teléfono tiene que tener el formato xxxx-xxxx"));
            else
                validationErrorMessage.addFieldError(new FieldError(fr.getObjectName(),fr.getField(),fr.getDefaultMessage()));
        }

        return new ResponseEntity<>(validationErrorMessage,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestRegisterExeception.class)
    public ResponseEntity<ErrorMessage> BadRequestRegisterException(BadRequestRegisterExeception ex){
        HttpStatus hs = HttpStatus.BAD_REQUEST;
        errorMessage = ex.getErrorMessage();
        errorMessage.setMessage(ex.getMessage());
        errorMessage.setStatus(hs.value());

        return new ResponseEntity<>(errorMessage,hs);



    }

}
