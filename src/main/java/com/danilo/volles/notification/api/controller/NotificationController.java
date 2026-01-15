package com.danilo.volles.notification.api.controller;

import com.danilo.volles.notification.api.dto.ApiResponseWrapper;
import com.danilo.volles.notification.api.dto.NotificationResponseDTO;
import com.danilo.volles.notification.api.service.NotificationService;
import com.danilo.volles.notification.api.dto.NotificationRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/send")
    public ResponseEntity<ApiResponseWrapper<NotificationResponseDTO>> sendNotification(@RequestBody NotificationRequestDTO request) throws InterruptedException {

        Thread.sleep(1200); // fake delay

        log.info("{} - request: {}", MDC.get("X-Correlation-Id"), request.toString());

        NotificationResponseDTO response = notificationService.sendNotification(request);

        log.info("{} - response: {}", MDC.get("X-Correlation-Id"), response.toString());

        return ResponseEntity.ok(new ApiResponseWrapper<>(response));
    }
}
