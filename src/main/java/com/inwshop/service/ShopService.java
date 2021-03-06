package com.inwshop.service;

import com.inwshop.model.ShopModel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ShopService {
    public Boolean createShop(ShopModel shopModel) throws IOException;
}
