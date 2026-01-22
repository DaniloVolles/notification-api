package com.danilo.volles.notification.api.dto;

import org.springframework.beans.factory.annotation.Value;

public record IsAppRunningInfo(boolean isAppRunning,
                               String applicationVersion,
                               String groupId,
                               String artifactId,
                               String projectName) {

    public IsAppRunningInfo(String applicationVersion,
                            String groupId,
                            String artifactId,
                            String projectName) {

        this(
                true,
                applicationVersion,
                groupId,
                artifactId,
                projectName
        );
    }
}