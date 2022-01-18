package com.example.individualproject.WebSocketsTests;
import com.example.individualproject.Controller.NotificationController;
import com.example.individualproject.Model.Message;
import com.example.individualproject.Model.Notification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.Test;
import org.springframework.web.util.HtmlUtils;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NotificationControllerTests {
    @Autowired
    NotificationController controller;

    @Test
    public void notifyTest(){
        Notification notification = new Notification();
        Message message = new Message("asd");
        Message message1 = new Message();

        message.getName();
        message.setName("asddsa");

    }
}
