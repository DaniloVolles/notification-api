package com.danilo.volles.notification.api.controller;

import com.danilo.volles.notification.api.dto.NotificationResponseDTO;
import com.danilo.volles.notification.api.service.NotificationService;
import com.danilo.volles.notification.api.dto.NotificationRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/send")
    public ResponseEntity<NotificationResponseDTO> sendNotification(@RequestBody NotificationRequestDTO request) throws InterruptedException {

        Thread.sleep(1200); // fake delay

        System.out.println("request: " + request.toString());

        NotificationResponseDTO response = notificationService.sendNotification(request);

        System.out.println("response: " + response.toString());

        return ResponseEntity.ok(response);
    }
}
