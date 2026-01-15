package com.danilo.volles.notification.api.config.serialization;

import com.danilo.volles.notification.api.entity.Notification;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;
import tools.jackson.databind.ObjectMapper;

@Slf4j
public class NotificationJsonSerializer implements Serializer<Notification> {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, Notification data) {
        try {

            if (data == null) return null;

            return mapper.writeValueAsBytes(data);

        } catch (Exception e) {
            log.info("Exception while serializing notification: ", e);
            log.info("Exception message: {}", e.getMessage());
            throw new RuntimeException("Serialization exception: ", e);
        }
    }
}
