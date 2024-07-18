package com.java.socket.io.pypisan.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.socket.io.pypisan.models.User;


/**
 * Repository is an interface that provides access to data in a database
 */

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
