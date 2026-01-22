package com.danilo.volles.notification.api.controller;

import com.danilo.volles.notification.api.dto.ApiResponseWrapper;
import com.danilo.volles.notification.api.dto.IsAppRunningInfo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("health")
public class HealthController {


    @Value("${app.version}")
    private String appVersion;

    @Value("${app.groupId}")
    private String groupId;

    @Value("${app.artifactId}")
    private String artifactId;

    @Value("${app.name}")
    private String appName;


    @GetMapping("is-app-running")
    private ResponseEntity<ApiResponseWrapper<IsAppRunningInfo>> isAppRunning() {
        log.info("{} - GET /is-app-running endpoint accessed", MDC.get("X-Correlation-Id"));

        var appInfo = new IsAppRunningInfo(
                appVersion,
                groupId,
                artifactId,
                appName
        );

        return ResponseEntity.ok(new ApiResponseWrapper<>(appInfo));
    }

}
