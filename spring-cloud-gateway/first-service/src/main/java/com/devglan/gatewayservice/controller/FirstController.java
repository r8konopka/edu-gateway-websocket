package com.devglan.gatewayservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @Autowired
    private SimpMessagingTemplate template;

    @GetMapping("/send/{message}")
    public void send(@PathVariable("message") String message){
        this.template.convertAndSend("/topic/reply", "First service: " + message);
    }

}
