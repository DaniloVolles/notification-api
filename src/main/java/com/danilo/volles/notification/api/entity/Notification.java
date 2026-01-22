package com.danilo.volles.notification.api.entity;

import com.danilo.volles.notification.api.dto.NotificationRequestDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document(collection = "notifications")
public class Notification {

    @Id
    private String id;

    private String message;
    private String title;
    private Instant creationDate;
    private String user;

    public Notification(NotificationRequestDTO requestDTO) {
        this.message        = requestDTO.message();
        this.title          = requestDTO.title();
        this.creationDate   = Instant.now();
        this.user           = requestDTO.user();
    }
}
