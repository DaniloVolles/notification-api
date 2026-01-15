package com.danilo.volles.notification.api.producer;

import com.danilo.volles.notification.api.entity.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationProducer {

    private final KafkaTemplate<String, Notification> kafkaTemplate;
    private final String TOPIC;

    public NotificationProducer(KafkaTemplate<String, Notification> kafkaTemplate,
                                @Value("${topic.name.producer}") String TOPIC) {
        this.kafkaTemplate = kafkaTemplate;
        this.TOPIC = TOPIC;
    }

    public void kafkaSendNotification(Notification notification) {
        kafkaTemplate.send(TOPIC, notification);
        log.warn("Notification sent to topic {}", TOPIC);
    }
}
