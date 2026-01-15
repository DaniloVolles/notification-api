package com.danilo.volles.notification.api.config;

import com.danilo.volles.notification.api.config.serialization.NotificationJsonSerializer;
import com.danilo.volles.notification.api.entity.Notification;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumer {

    @Value(value = "${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapAddress;

    @Value(value = "${spring.kafka.consumer.group-id}")
    private String groupId;

    @Bean
    public ConsumerFactory<String, Notification> notificationConsumerFactory() {

        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, NotificationJsonSerializer.class);
        return new DefaultKafkaConsumerFactory<>(configProps);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Notification> documentKafkaListenerContainerFactory() {
        var factory = new ConcurrentKafkaListenerContainerFactory<String, Notification>();
        factory.setConsumerFactory(notificationConsumerFactory());
        return factory;
    }

}
