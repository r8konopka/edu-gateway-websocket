package com.devglan.gatewayservice.secondservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondController {

    @Autowired
    private SimpMessagingTemplate template;

    @GetMapping("/send/{message}")
    public void send(@PathVariable("message") String message){
        this.template.convertAndSend("/topic/reply", "Second service: " + message);
    }

}
