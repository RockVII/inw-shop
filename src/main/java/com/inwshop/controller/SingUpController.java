package com.inwshop.controller;

import com.inwshop.model.SingUp;
import com.inwshop.service.SingUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/singup")
public class SingUpController {

    @Autowired
    @Qualifier("singUpServiceImpl")
    private SingUpService singUpService;

    @PostMapping("/register")
    public String register(@Valid @RequestBody  SingUp singup) {
        Boolean registered = singUpService.register(singup);
        return "SIUUU";
    }

    @GetMapping("/test")
    public String test(){
        return "OK";
    }
}
