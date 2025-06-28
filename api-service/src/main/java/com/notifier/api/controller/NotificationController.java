package com.notifier.api.controller;

import com.notifier.common.dto.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notify")
public class NotificationController {

    @Autowired
    private KafkaTemplate<String, NotificationRequest> kafkaTemplate;

    @PostMapping
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest request) {
        kafkaTemplate.send("notification-topic", request);
        return ResponseEntity.ok("Notification sent to dispatcher.");
    }
}
