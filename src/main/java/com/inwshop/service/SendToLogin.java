package com.inwshop.service;

import com.google.gson.Gson;
import com.inwshop.model.LoginCredentials;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.*;

public class SendToLogin {

    public static String send(String email, String password) throws IOException {
        HttpClient http = HttpClientBuilder.create().build();
        try{
            HttpPost request = new HttpPost("https://inw-login.herokuapp.com/login");
            LoginCredentials loginCredentials = new LoginCredentials(email,password);
            Gson gson = new Gson();
            String json = gson.toJson(loginCredentials);
            StringEntity params = new StringEntity(json);
            request.addHeader("content-type","application/json");
            request.addHeader("Accept","application/json");
            request.setEntity(params);
            HttpResponse response = http.execute(request);
            String respuesta = EntityUtils.toString(response.getEntity());
            System.out.println(json.toString());
            System.out.println(respuesta);
            return respuesta;


        }catch (Exception ex){
            return null;
        }
    }
}
