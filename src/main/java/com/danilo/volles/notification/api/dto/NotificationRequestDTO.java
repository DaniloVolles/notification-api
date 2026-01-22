package com.danilo.volles.notification.api.dto;

import com.danilo.volles.notification.api.entity.RecipientTypes;

public record NotificationRequestDTO(String message,
                                     String title,
                                     String user) {
}
