package com.inwshop.service;

import com.inwshop.model.SingUp;

import java.io.IOException;

public interface SingUpService {
    public abstract  Boolean register(SingUp singup);
    public abstract  String sendToLogin(String email) throws IOException;
}
