package mx.edu.unsis.loteria.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import mx.edu.unsis.loteria.dto.ChatMessage;

@Controller
public class WebSocketController {
    @MessageMapping("/loteria-websocket/{roomId}")
    @SendTo("/topic/{roomId}")
    public ChatMessage chat(@DestinationVariable String roomId, ChatMessage message){
        System.out.println(message);
        return new ChatMessage(message.getMessage(),message.getUser());
    }
}
