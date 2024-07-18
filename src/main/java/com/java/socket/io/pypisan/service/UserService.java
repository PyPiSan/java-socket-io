package com.java.socket.io.pypisan.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.socket.io.pypisan.models.User;
import com.java.socket.io.pypisan.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;




@Service
@RequiredArgsConstructor
@Log4j2
public class UserService {

    @Autowired
    private final UserRepository userRepository;


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    public User getUserById(UUID id){
        Optional<User> optionalEmployee = userRepository.findById(id);
        if(optionalEmployee.isPresent()){
            return optionalEmployee.get();
        }
        log.info("Employee with id: {} doesn't exist", id);
        return null;
    }


    public User saveUser(User user){

        user.joinedOn(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        User saveduser = userRepository.save(user);

        log.info("Employee with id: {} saved successfully", saveduser.getId());
        return saveduser;
    }


    public void deleteUserById (UUID id) {
        userRepository.deleteById(id);
        }
}
