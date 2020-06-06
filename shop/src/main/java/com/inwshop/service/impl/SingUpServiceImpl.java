package com.inwshop.service.impl;

import com.inwshop.exception.BadRequestRegisterExeception;
import com.inwshop.model.ErrorMessage;
import com.inwshop.model.SingUp;
import com.inwshop.repository.SingUpRepository;
import com.inwshop.service.SingUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SingUpServiceImpl implements SingUpService {

    @Autowired
    private SingUpRepository singUpReposiory;

    @Autowired
    private ErrorMessage errorMessage;

    @Override
    public Boolean register(SingUp singup){
        singup.setPreference(1);
        singup.setRoleId(1);
        singUpReposiory.duplicateKey("email",singup.getEmail());
        singUpReposiory.duplicateKey("user_name",singup.getUserName());
        errorMessage = singUpReposiory.duplicateKey("phone",singup.getPhone());
        if(errorMessage.getFieldErrors().size() > 0)
            throw new BadRequestRegisterExeception("Datos duplicados",errorMessage);

        return singUpReposiory.register(singup);
    }
}
