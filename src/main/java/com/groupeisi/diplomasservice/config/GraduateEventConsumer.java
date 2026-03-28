package com.groupeisi.diplomasservice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GraduateEventConsumer {

    @KafkaListener(topics = "GRADUATE_UPDATED", groupId = "diplomas-group")
    public void consume(String message) {
        log.info("Événement reçu par diplomas-service : {}", message);
    }
}