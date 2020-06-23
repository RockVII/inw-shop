package com.inwshop.service.impl;

import com.inwshop.DTO.UserDTO;
import com.inwshop.model.ShopModel;
import com.inwshop.repository.ShopRepository;
import com.inwshop.service.ShopService;
import com.inwshop.utils.UserDetailsLogged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ShopServiceImpl implements ShopService {

    private static final String UPLOADED_FOLDER = "src\\main\\resources\\static\\shopImages\\";

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private UserDetailsLogged userDetailsLogged;

    @Override
    public Boolean createShop(ShopModel shopModel) {
        shopModel.setImagePath(shopModel.getImagePath().replaceAll("\\/", "//"));
        UserDTO user = userDetailsLogged.getUser();
        shopRepository.createShop(shopModel,user.getId());
        return true;
    }
}
