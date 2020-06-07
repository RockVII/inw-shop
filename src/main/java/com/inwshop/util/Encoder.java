package com.inwshop.util;

import org.apache.commons.codec.binary.Base64;

public class Encoder {

    public static final String encoder(String password){
        Base64 base64 = new Base64();
        String encodedPassword = new String(base64.encode(password.getBytes()));
        return encodedPassword;
    }

    public static final String decoder(String password){
        Base64 base64 = new Base64();
        String decodePassword = new String(base64.decode(password.getBytes()));
        return decodePassword;
    }
}
