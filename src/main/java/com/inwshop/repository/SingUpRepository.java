package com.inwshop.repository;

import com.inwshop.DTO.ErrorDTO;
import com.inwshop.DTO.FieldErrorDTO;
import com.inwshop.exceptions.BadRequestRegisterExeception;
import com.inwshop.model.SingUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SingUpRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static ErrorDTO errorMessage = new ErrorDTO();

    private static int contadorEventoDuplicado = 0;

    public Boolean register(SingUp singup){

        int insert = 0;

            String sql = "INSERT INTO J0120_user (rol_id,password,email,first_name,last_name,phone) VALUES (?,?,?,?,?,?)";
            insert = jdbcTemplate.update(sql, singup.getRol(),
                    singup.getPassword(), singup.getEmail(), singup.getName(),
                    singup.getLastName(), singup.getPhone());

        return insert > 0;
    }

    public ErrorDTO duplicateKey(String key, String value) throws BadRequestRegisterExeception{
        System.out.println("Miau base duplicateKey");
        String sql = "SELECT COUNT(*) FROM J0120_user WHERE "+key+" = ? LIMIT 1";
        Integer exists = jdbcTemplate.queryForObject(sql,Integer.class,value);
        contadorEventoDuplicado++;
        if(contadorEventoDuplicado == 3){
            errorMessage.clearFieldErrors();
            contadorEventoDuplicado = 1;
        }
        if (exists > 0){
            if(key.equals("email"))
                errorMessage.addFieldError(new FieldErrorDTO(key,"El email ya está registrado por otra cuenta"));
            else if(key.equals("phone"))
                errorMessage.addFieldError(new FieldErrorDTO(key,"El número de teléfono ya está registrado por otra cuenta"));
        }
        return errorMessage;
    }

    public SingUp findUserByEmail(String email){
        String sql = "SELECT * FROM  J0120_user WHERE email = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{email},(rs, rowNum) ->
                new SingUp(
                        rs.getInt("id"),
                        rs.getInt("rol_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("password")
                ));
    }

}
