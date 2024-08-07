package com.java.socket.io.pypisan.service;

import org.springframework.stereotype.Service;
import com.corundumstudio.socketio.SocketIOClient;
import com.java.socket.io.pypisan.enums.MessageType;
import com.java.socket.io.pypisan.models.Message;
import lombok.RequiredArgsConstructor;
// import lombok.extern.log4j.Log4j2;



@Service
@RequiredArgsConstructor
// @Log4j2
public class SocketService {

    private final MessageService messageService;

    public void sendSocketmessage(SocketIOClient senderClient, Message message, String room) {
        for (
            SocketIOClient client: senderClient.getNamespace().getRoomOperations(room).getClients()
        ) {
            if (!client.getSessionId().equals(senderClient.getSessionId())) {
                client.sendEvent("read_message", message);
            }
        }
    }

    public void saveMessage(SocketIOClient senderClient, Message message) {

        Message storedMessage = messageService.saveMessage(
            Message.builder()
                .messageType(MessageType.CLIENT)
                .message(message.getMessage())
                .room(message.getRoom())
                .username(message.getUsername())
                .build()
        );

        sendSocketmessage(senderClient, storedMessage, message.getRoom());

    }

    public void saveInfoMessage(SocketIOClient senderClient, String message, String room) {
        Message storedMessage = messageService.saveMessage(
            Message.builder()
                .messageType(MessageType.SERVER)
                .message(message)
                .room(room)
                .build()
        );

        sendSocketmessage(senderClient, storedMessage, room);
    }
    
}
