package com.danilo.volles.notification.api.dto;

import com.danilo.volles.notification.api.entity.Notification;

import java.time.Instant;

public record NotificationResponseDTO(String title,
                                      String message,
                                      Instant creationDate,
                                      String recipient) {

    public NotificationResponseDTO(Notification notification) {
        this(
                notification.getTitle(),
                notification.getMessage(),
                notification.getCreationDate(),
                String.valueOf(notification.getRecipient())
        );
    }
}
