package com.java.socket.io.pypisan.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.java.socket.io.pypisan.models.Message;
import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {
    List<Message> findAllByRoom(String room);
}
