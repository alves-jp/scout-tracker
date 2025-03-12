package com.scout_tracker.config.impl;

import com.scout_tracker.config.RabbitMQConfig;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@Validated
@EnableConfigurationProperties(RabbitMQConfigImpl.RabbitMQProperties.class)
public class RabbitMQConfigImpl implements RabbitMQConfig {

    private final RabbitMQProperties rabbitMQProperties;

    public RabbitMQConfigImpl(RabbitMQProperties rabbitMQProperties) {
        this.rabbitMQProperties = rabbitMQProperties;
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(rabbitMQProperties.getExchange().getNotification());
    }

    @Bean
    public Queue commentNotificationQueue() {
        return new Queue(rabbitMQProperties.getQueue().getObservation().getNotification());
    }

    @Bean
    public Binding commentNotificationBinding() {
        return BindingBuilder.bind(commentNotificationQueue())
                .to(exchange())
                .with(rabbitMQProperties.getRoutingKey().getObservation().getNotification());
    }

    @Bean
    public Queue replyNotificationQueue() {
        return new Queue(rabbitMQProperties.getQueue().getReply().getNotification());
    }

    @Bean
    public Binding replyNotificationBinding() {
        return BindingBuilder.bind(replyNotificationQueue())
                .to(exchange())
                .with(rabbitMQProperties.getRoutingKey().getReply().getNotification());
    }

    @Override
    public RabbitTemplate amqpTemplate() {
        return null;
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @ConfigurationProperties(prefix = "rabbitmq")
    public static class RabbitMQProperties {
        private Exchange exchange = new Exchange();
        private Queue queue = new Queue();
        private RoutingKey routingKey = new RoutingKey();

        public Exchange getExchange() {
            return exchange;
        }

        public void setExchange(Exchange exchange) {
            this.exchange = exchange;
        }

        public Queue getQueue() {
            return queue;
        }

        public void setQueue(Queue queue) {
            this.queue = queue;
        }

        public RoutingKey getRoutingKey() {
            return routingKey;
        }

        public void setRoutingKey(RoutingKey routingKey) {
            this.routingKey = routingKey;
        }

        public static class Exchange {
            @NotEmpty
            private String notification;

            public String getNotification() {
                return notification;
            }

            public void setNotification(String notification) {
                this.notification = notification;
            }
        }

        public static class Queue {
            private Observation observation = new Observation();
            private Reply reply = new Reply();

            public Observation getObservation() {
                return observation;
            }

            public void setObservation(Observation observation) {
                this.observation = observation;
            }

            public Reply getReply() {
                return reply;
            }

            public void setReply(Reply reply) {
                this.reply = reply;
            }

            public static class Observation {
                @NotEmpty
                private String notification;

                public String getNotification() {
                    return notification;
                }

                public void setNotification(String notification) {
                    this.notification = notification;
                }
            }

            public static class Reply {
                @NotEmpty
                private String notification;

                public String getNotification() {
                    return notification;
                }

                public void setNotification(String notification) {
                    this.notification = notification;
                }
            }
        }

        public static class RoutingKey {
            private Observation observation = new Observation();
            private Reply reply = new Reply();

            public Observation getObservation() {
                return observation;
            }

            public void setObservation(Observation observation) {
                this.observation = observation;
            }

            public Reply getReply() {
                return reply;
            }

            public void setReply(Reply reply) {
                this.reply = reply;
            }

            public static class Observation {
                @NotEmpty
                private String notification;

                public String getNotification() {
                    return notification;
                }

                public void setNotification(String notification) {
                    this.notification = notification;
                }
            }

            public static class Reply {
                @NotEmpty
                private String notification;

                public String getNotification() {
                    return notification;
                }

                public void setNotification(String notification) {
                    this.notification = notification;
                }
            }
        }
    }
}
