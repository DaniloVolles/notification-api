package com.danilo.volles.notification.api.repository;

import com.danilo.volles.notification.api.entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NotificationRepository extends MongoRepository<Notification, UUID> {

}
