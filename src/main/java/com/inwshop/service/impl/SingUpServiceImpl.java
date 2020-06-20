package com.inwshop.service.impl;

import com.inwshop.DTO.ErrorDTO;
import com.inwshop.exceptions.BadRequestRegisterExeception;
import com.inwshop.model.ErrorMessage;
import com.inwshop.model.SingUp;
import com.inwshop.repository.SingUpRepository;
import com.inwshop.service.SendToLogin;
import com.inwshop.service.SingUpService;
import com.inwshop.utils.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class SingUpServiceImpl implements SingUpService {

    @Autowired
    private SingUpRepository singUpReposiory;

//    @Autowired
//    private ErrorMessage errorMessage;

    private static ErrorDTO errorMessage = new ErrorDTO();

    @Override
    public Boolean register(SingUp singup){
        singUpReposiory.duplicateKey("email",singup.getEmail());
        errorMessage = singUpReposiory.duplicateKey("phone",singup.getPhone());
        if(errorMessage.getErrors().size() > 0)
            throw new BadRequestRegisterExeception("Datos duplicados",errorMessage);
        singup.setPassword(Encoder.encoder(singup.getPassword()));
        return singUpReposiory.register(singup);
    }

    @Override
    public String sendToLogin(String email) throws IOException {
        SingUp userLoginData = singUpReposiory.findUserByEmail(email);
        return  userLoginData.toString();
    }
}
