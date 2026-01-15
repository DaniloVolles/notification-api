package com.danilo.volles.notification.api.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
import tools.jackson.databind.deser.jdk.StringDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopic {

    @Value(value = "${spring.kafka.producer.bootstrap-servers}")
    private String bootstrapAddress;

    @Value(value = "${topics.documents.request}")
    private static String TOPIC;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic notifications() {
        return TopicBuilder
                .name(TOPIC)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
