package com.inwshop.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encoder {

    public static final String encoder(String password){
        BCryptPasswordEncoder bCrypt= new BCryptPasswordEncoder();
        return bCrypt.encode(password);
    }
}
