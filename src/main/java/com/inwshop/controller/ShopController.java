package com.inwshop.controller;

import com.inwshop.DTO.ResponseDTO;
import com.inwshop.model.DataModel;
import com.inwshop.model.ShopModel;
import com.inwshop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/create", method = RequestMethod.POST )
    @PreAuthorize("hasRole('ROLE_vendedor')")
    public ResponseEntity<?> createShop(@RequestParam("image") MultipartFile image, @RequestParam("name") String name) throws IOException {
        shopService.createShop(image,name);
        return new  ResponseEntity<ResponseDTO>(new ResponseDTO(new DataModel("Tienda guardada")),HttpStatus.OK);


    }
}
