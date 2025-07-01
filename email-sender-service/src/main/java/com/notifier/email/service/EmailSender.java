package com.notifier.email.service;

import com.notifier.common.dto.NotificationRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

    @KafkaListener(topics = "email-topic", groupId = "email-sender-group")
    public void sendEmail(NotificationRequest request) {
        System.out.println("✅ [EmailSender] Sending email to: " + request.getRecipient());
        System.out.println("✉️ Message: " + request.getMessage());
    }
}
