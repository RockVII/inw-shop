package com.inwshop.controller;

import com.inwshop.exceptions.BadRequestRegisterExeception;
import com.inwshop.model.ErrorMessage;
import com.inwshop.model.LoginCredentials;
import com.inwshop.model.SingUp;
import com.inwshop.service.SendToLogin;
import com.inwshop.service.SingUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;


@RestController
@RequestMapping("/signup")
public class SingUpController {

    @Autowired
    @Qualifier("singUpServiceImpl")
    private SingUpService singUpService;


    @PostMapping("/register")
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> register(@Valid @RequestBody  SingUp singup) throws IOException {
        String email = singup.getEmail();
        String password = singup.getPassword();
        if(singUpService.register(singup)) {
            String response = SendToLogin.send(email,password);
            return ResponseEntity.ok().body(response);
        }
        return null;
    }


    @GetMapping("/ver")
    public ResponseEntity<LoginCredentials> ver(){
        return new ResponseEntity<LoginCredentials>(new LoginCredentials("dsfsd", "dfsdfs"), HttpStatus.OK) {
        };
    }

    @GetMapping("/ver1")
    @PreAuthorize("permitAll()")
    public String prueba(){
        return "Hola papu";
    }
}
