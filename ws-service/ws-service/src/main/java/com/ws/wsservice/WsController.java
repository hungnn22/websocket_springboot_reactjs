package com.ws.wsservice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ws/test")
@RequiredArgsConstructor
public class WsController {
    private final SimpMessagingTemplate ws;

    @GetMapping("/notification")
    public Object testNotification4Admin(String message) {
        ws.convertAndSend("topic/notification", message);
        return message;
    }
}
