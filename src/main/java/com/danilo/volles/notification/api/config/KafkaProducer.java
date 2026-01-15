package com.danilo.volles.notification.api.config;

import com.danilo.volles.notification.api.config.serialization.NotificationJsonSerializer;
import com.danilo.volles.notification.api.entity.Notification;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducer {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Bean
    public ProducerFactory<String, Notification> notificationProducerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, NotificationJsonSerializer.class);
        return new DefaultKafkaProducerFactory<String, Notification>(config);
    }

    @Bean
    public KafkaTemplate<String, Notification> notificationKafkaTemplate() {
        return new KafkaTemplate<>(notificationProducerFactory());
    }
}
