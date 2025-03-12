package com.scout_tracker.infrastructure.messaging.consumer;

import com.scout_tracker.infrastructure.aws.SESSService;
import com.scout_tracker.infrastructure.messaging.model.ObservationNotification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class ObservationNotificationConsumer {

    private final SESSService sesService;

    public ObservationNotificationConsumer(SESSService sesService) {
        this.sesService = sesService;
    }

    @RabbitListener(queues = {"${rabbitmq.queue.observation.notification}"})
    public void consumeJsonMessage(ObservationNotification notification) {
        prepareAndSendEmail(notification);
    }

    public void prepareAndSendEmail(ObservationNotification notification) {
        String body = String.format("Olá, %s! Veja a sua nova observação: %s",
                notification.observationAuthor().getScoutName(),
                notification.createdObservation().getObservation());

        String subject = String.format("%s, sua observação foi registrada com sucesso!",
                notification.observationAuthor().getScoutName());

        String toEmail = notification.observationAuthor().getEmail();

        sesService.sendEmail(subject, body, toEmail);
    }
}
