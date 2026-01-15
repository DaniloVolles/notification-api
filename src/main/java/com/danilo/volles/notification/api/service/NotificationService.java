package com.danilo.volles.notification.api.service;

import com.danilo.volles.notification.api.dto.NotificationRequestDTO;
import com.danilo.volles.notification.api.dto.NotificationResponseDTO;
import com.danilo.volles.notification.api.entity.Notification;
import com.danilo.volles.notification.api.producer.NotificationProducer;
import com.danilo.volles.notification.api.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationProducer notificationProducer;

    public NotificationResponseDTO sendNotification(NotificationRequestDTO request) {

        var notification = new Notification(request);

        System.out.println("notification: " + notification.toString());

        notificationRepository.save(notification);

        notificationProducer.kafkaSendNotification(notification);

        return new NotificationResponseDTO(notification);
    }
}
