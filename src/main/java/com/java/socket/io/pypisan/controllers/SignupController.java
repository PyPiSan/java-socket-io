package com.java.socket.io.pypisan.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.java.socket.io.pypisan.constants.Constant;
import com.java.socket.io.pypisan.models.User;
import com.java.socket.io.pypisan.utils.Response;
import lombok.extern.log4j.Log4j2;



@RestController
@Log4j2
public class SignupController {
    

    @PostMapping("/register")
    public ResponseEntity<Response> newRegistration(@Validated @RequestBody User newUser){
        Response response = new Response();
        log.debug("Input User value", newUser);
        if (newUser.getUserName() == null || newUser.getUserName().equals("")){
            response.setStatus(Constant.failed);
            response.setMessage(Constant.userRequired);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } else if (newUser.getEmailId() == null || newUser.getEmailId().equals("")){
            response.setStatus(Constant.failed);
            response.setMessage(Constant.emailRequired);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } else if (newUser.getProfileUrl() == null || newUser.getProfileUrl().equals("")){
            response.setStatus(Constant.failed);
            response.setMessage(Constant.profileUrlRequired);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        else {
            response.setStatus(Constant.success);
            response.setMessage("");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    
    }

}
