package com.scout_tracker.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public interface RabbitMQConfig {

    TopicExchange exchange();

    Queue commentNotificationQueue();

    Binding commentNotificationBinding();

    Queue replyNotificationQueue();

    Binding replyNotificationBinding();

    RabbitTemplate amqpTemplate();
}
