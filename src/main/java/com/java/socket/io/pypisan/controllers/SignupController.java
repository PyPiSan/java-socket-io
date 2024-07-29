package com.java.socket.io.pypisan.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.java.socket.io.pypisan.constants.Constant;
import com.java.socket.io.pypisan.models.User;
import com.java.socket.io.pypisan.service.UserService;
import com.java.socket.io.pypisan.utils.PasswordGenerator;
import com.java.socket.io.pypisan.utils.Response;
import lombok.extern.log4j.Log4j2;



@RestController
@Log4j2
public class SignupController {

    @Autowired    
    private UserService userService;
    

    @PostMapping("/register")
    public ResponseEntity<Response> newRegistration(@Validated @RequestBody User newUser){
        Response response = new Response();
        PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
        .useDigits(true)
        .useLower(true)
        .useUpper(true)
        .build();
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
            if (userService.getUserByEmail(newUser.getEmailId()) != null){
                response.setStatus(Constant.failed);
                response.setMessage(Constant.userExists);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
            String pass = passwordGenerator.generate(8);
            newUser.setPassword(pass);
            userService.saveUser(newUser);
            response.setStatus(Constant.success);
            response.setMessage("use the password for login "+pass);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    
    }

}
