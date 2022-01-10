package com.example.individualproject.Controller;

import com.example.individualproject.Model.Message;
import com.example.individualproject.Model.Notification;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;

@Controller
public class NotificationController {

    @MessageMapping("/notify")
    @SendTo("/topic/notifications")
    public Notification notify(Message message) throws Exception {
        return new Notification(HtmlUtils.htmlEscape(message.getName()));
    }

}
