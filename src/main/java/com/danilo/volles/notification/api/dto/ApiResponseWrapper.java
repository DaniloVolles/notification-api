package com.danilo.volles.notification.api.dto;

import org.slf4j.MDC;

import java.time.Instant;

public record ApiResponseWrapper<T>(String correlationId,
                                 Instant timestamp,
                                 Object data) {

    public ApiResponseWrapper(Object data) {

        this(MDC.get("X-Correlation-Id"), Instant.now(), data);
    }
}
