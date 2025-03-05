package com.scout_tracker.infrastructure.messaging.producer;

import com.scout_tracker.domain.dto.ScoutDTO;
import com.scout_tracker.domain.dto.ScoutObservationDTO;
import com.scout_tracker.infrastructure.model.ObservationNotification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ObservationNotificationProducer {
    @Value("${rabbitmq.exchange.notification}")
    private String notificationExchange;

    @Value("${rabbitmq.routing.key.observation.notification}")
    private String observationNotificationKey;

    private final RabbitTemplate rabbitTemplate;

    public ObservationNotificationProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void addObservationNotification(ScoutDTO observationAuthor, ScoutObservationDTO createdObservation) {
        ObservationNotification notification = new ObservationNotification(observationAuthor, createdObservation);
        rabbitTemplate.convertAndSend(notificationExchange, observationNotificationKey, notification);
    }
}
