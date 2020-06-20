package com.inwshop.repository;

import com.inwshop.model.ShopModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShopRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Boolean createShop(ShopModel shop,int userId){
        String sql = "INSERT INTO J0120_shop (user_id,name,imagePath,global_rate) VALUES(?,?,?,?)";

        int insert = jdbcTemplate.update(sql,userId,shop.getName(),shop.getImagePath(),0);
        return insert> 0;
    }
}
