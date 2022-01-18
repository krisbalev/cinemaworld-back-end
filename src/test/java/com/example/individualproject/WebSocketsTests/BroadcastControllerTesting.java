package com.example.individualproject.WebSocketsTests;

import com.example.individualproject.Controller.BroadcastController;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BroadcastControllerTesting {

    @Autowired
    BroadcastController controller;

//    @MockBean
//    SimpMessagingTemplate simpMessagingTemplate;

    @Test
    public void hi(){
        String message = "asd";

        Assertions.assertEquals("message sent ...", controller.hi(message));
    }
}
