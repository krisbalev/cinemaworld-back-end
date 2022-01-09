package com.example.individualproject.Controller;

import com.example.individualproject.Model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")
public class BroadcastController {

    private final SimpMessagingTemplate msgTemplate;

    @Autowired
    public BroadcastController(SimpMessagingTemplate msgTemplate){
        this.msgTemplate = msgTemplate;
    }

    @GetMapping("/broadcast")
    public String hi(@RequestBody String message) {
        Notification notification = new Notification(message);
        msgTemplate.convertAndSend("/topic/broadcast", notification);
        return "message sent ...";
    }
}
