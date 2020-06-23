package com.devglan.gatewayservice.controller;

import com.google.gson.Gson;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class WebSocketController {

	@MessageMapping("/message")
	@SendTo("/topic/reply")
	public String processMessageFromClient(@Payload String message){
		String name = new Gson().fromJson(message, Map.class).get("name").toString();
		return "From first service " + name;
	}

	@MessageExceptionHandler
    @SendToUser("/topic/errors")
    public String handleException(Throwable exception) {
        return exception.getMessage();
    }

}