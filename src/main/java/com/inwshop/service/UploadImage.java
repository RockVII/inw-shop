package com.inwshop.service;

import com.google.gson.Gson;
import com.inwshop.model.ImageModel;
import com.inwshop.model.LoginCredentials;
import com.inwshop.utils.MultipartFileToFile;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class UploadImage {

    public static String upload(MultipartFile image, String name){
        HttpClient http = HttpClientBuilder.create().build();
        try{
            HttpPost request = new HttpPost("https://luisvelago.000webhostapp.com/email/email/subirImagen");
            File imageFile = MultipartFileToFile.convertMultiPartToFile(image);
            ImageModel imageModel = new ImageModel(image,name);
            Gson gson = new Gson();
            String json = gson.toJson(imageModel);
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
