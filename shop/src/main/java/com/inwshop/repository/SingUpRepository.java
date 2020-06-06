package com.inwshop.repository;

import com.inwshop.exception.BadRequestRegisterExeception;
import com.inwshop.model.ErrorMessage;
import com.inwshop.model.FieldErrorsModel;
import com.inwshop.model.SingUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SingUpRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ErrorMessage errorMessage;

    private static int contadorEventoDuplicado = 0;

    public Boolean register(SingUp singup){
        int insert = 0;

            String sql = "INSERT INTO user (rol_id,user_name,password,email,first_name,last_name,phone,preference) VALUES (?,?,?,?,?,?,?,?)";
            insert = jdbcTemplate.update(sql, singup.getRoleId(), singup.getUserName(),
                    singup.getPassword(), singup.getEmail(), singup.getFirstName(),
                    singup.getLastName(), singup.getPhone(), singup.getPreference());

        return insert > 0;
    }

    public ErrorMessage duplicateKey(String key, String value) throws BadRequestRegisterExeception{
        String sql = "SELECT COUNT(*) FROM user WHERE "+key+" = ? LIMIT 1";
        Integer exists = jdbcTemplate.queryForObject(sql,Integer.class,value);
        contadorEventoDuplicado++;
        if(contadorEventoDuplicado == 4){
            errorMessage.clearFieldErrors();
            contadorEventoDuplicado = 1;
        }
        if (exists > 0){
            if(key.equals("email"))
                errorMessage.addFieldError(new FieldErrorsModel(key,"El email ya está registrado por otra cuenta"));
            else if(key.equals("user_name"))
                errorMessage.addFieldError(new FieldErrorsModel("userName","El nombre de usuario ya está registrado por otra cuenta"));
            else if(key.equals("phone"))
                errorMessage.addFieldError(new FieldErrorsModel(key,"El número de teléfono ya está registrado por otra cuenta"));
        }
        return errorMessage;
    }
}
