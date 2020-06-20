package com.inwshop.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ShopService {
    public Boolean createShop(MultipartFile file, String name) throws IOException;
}
