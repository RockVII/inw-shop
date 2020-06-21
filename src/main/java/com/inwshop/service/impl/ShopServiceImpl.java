package com.inwshop.service.impl;

import com.inwshop.DTO.UserDTO;
import com.inwshop.model.ShopModel;
import com.inwshop.model.SingUp;
import com.inwshop.repository.ShopRepository;
import com.inwshop.repository.SingUpRepository;
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
    public Boolean createShop(MultipartFile file, String name) throws IOException {
        Integer numero = Math.toIntExact(Math.round(Math.random()*1000));
        String nameFormat = file.getOriginalFilename().toLowerCase().replace(" ","");
        String[] nameParts = nameFormat.split("\\.");
        String nameUnique = nameParts[0]+numero+"."+nameParts[1];
        String pathImage = UPLOADED_FOLDER+nameUnique;
        byte[] bytes = file.getBytes();
        Path path = Paths.get(pathImage);
        Files.write(path,bytes);
        String Uri = path.toAbsolutePath().toUri().toString();
        UserDTO user = userDetailsLogged.getUser();
        shopRepository.createShop(new ShopModel(name,Uri),user.getId());
        return true;
    }
}
