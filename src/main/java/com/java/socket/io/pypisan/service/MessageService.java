package com.java.socket.io.pypisan.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.java.socket.io.pypisan.models.Message;
import com.java.socket.io.pypisan.repository.MessageRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor()
public class MessageService {

    private final MessageRepository messageRepository;

    public List<Message> getMessage(String room) {
        return messageRepository.findAllByRoom(room);
    }

    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }
}