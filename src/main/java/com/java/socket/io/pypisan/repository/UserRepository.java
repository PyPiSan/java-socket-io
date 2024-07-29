package com.java.socket.io.pypisan.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.socket.io.pypisan.models.User;



@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
