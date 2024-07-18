package com.java.socket.io.pypisan.controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.socket.io.pypisan.models.SignupModel;

import lombok.extern.log4j.Log4j2;



@RestController
@Log4j2
public class SignupController {
    

    @PostMapping("/signup")
    public String newSignup(@Validated @RequestBody SignupModel newSignup){
        log.info("Perform operation on user signup");
        return "Signup success";
    }

    @GetMapping("/user")
    public String getUser(@RequestBody SignupModel newSignup){
        log.info("Perform operation on user signup");
        return "User success";
    }
}
