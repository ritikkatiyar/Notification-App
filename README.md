# Notification-App
✅1. api-service
   REST API entry point, exposes endpoints to trigger notifications

✅ 2. dispatcher-service
Routes requests to email/sms services, connects via Kafka

✅ 3. email-sender-service
Consumes Kafka topic and mocks sending email

✅ 4. sms-sender-service
Consumes Kafka topic and mocks sending SMS

✅ 5. retry-scheduler-service
Periodic retry logic using Kafka + Redis queue

[API Client]
│
▼
api-service
└── kafkaTemplate.send("notification-topic", request);
│
▼
Kafka Topic: notification-topic
│
▼
dispatcher-service
└── @KafkaListener(topics = "notification-topic")
route(NotificationRequest request)
└── kafkaTemplate.send("email-topic", request);
└── Kafka Topic: email-topic
▼
email-sender-service (listener)


