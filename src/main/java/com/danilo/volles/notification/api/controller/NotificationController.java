package com.danilo.volles.notification.api.controller;

import com.danilo.volles.notification.api.service.NotificationService;
import com.danilo.volles.notification.api.dto.NotificationRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(NotificationRequestDTO request) {
        notificationService.sendNotification(request);
        return ResponseEntity.ok("Notification sent successfully");
    }
}
