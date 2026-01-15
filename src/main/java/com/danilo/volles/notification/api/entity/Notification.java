package com.danilo.volles.notification.api.entity;

import com.danilo.volles.notification.api.dto.NotificationRequestDTO;
import lombok.Data;

import java.time.Instant;

@Data
public class Notification {
    private String message;
    private String title;
    private Instant creationDate;
    private RecipientTypes recipient;

    public Notification(NotificationRequestDTO requestDTO) {
        this.message        = requestDTO.message();
        this.title          = requestDTO.title();
        this.creationDate   = Instant.now();
        this.recipient      = requestDTO.recipient();
    }
}
