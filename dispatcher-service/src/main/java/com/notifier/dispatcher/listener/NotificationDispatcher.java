package com.notifier.dispatcher.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.notifier.common.dto.NotificationRequest;

@Service
public class NotificationDispatcher {
    @Autowired
    private KafkaTemplate<String,NotificationRequest> kafkaTemplate;

    @KafkaListener(topics = "notification-topic",groupId = "dispatcher-group")
    public void route(NotificationRequest request){
        if("EMAIL".equalsIgnoreCase(request.getChannel())){
            kafkaTemplate.send("email-topic",request);
        }else if("SMS".equalsIgnoreCase(request.getChannel())){
            kafkaTemplate.send("sms-topic",request);
        }
    }
}
