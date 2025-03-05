package com.scout_tracker.infrastructure.aws;

import com.scout_tracker.config.ServicesConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;

@Service
public class SESSService {

    private static final Logger logger = LoggerFactory.getLogger(SESSService.class);

    private final ServicesConfig servicesConfig;
    private final String notificationSenderEmail;
    private final SesClient client;

    public SESSService(ServicesConfig servicesConfig) {
        this.servicesConfig = servicesConfig;
        this.client = servicesConfig.sesClient();
        this.notificationSenderEmail = servicesConfig.getNotificationSenderEmail();
    }

    public void sendEmail(String subject, String body, String toEmail) {
        if (!StringUtils.hasText(subject) || !StringUtils.hasText(body) || !StringUtils.hasText(toEmail)) {
            throw new IllegalArgumentException("Assunto, corpo ou destinatário do e-mail não podem ser vazios.");
        }

        SendEmailRequest request = SendEmailRequest.builder()
                .destination(Destination.builder().toAddresses(toEmail).build())
                .message(Message.builder()
                        .body(Body.builder()
                                .html(Content.builder().charset("UTF-8").data(body).build())
                                .text(Content.builder().charset("UTF-8").data("Versão em texto simples do e-mail").build())
                                .build())
                        .subject(Content.builder().charset("UTF-8").data(subject).build())
                        .build())
                .source(notificationSenderEmail)
                .build();

        try {
            client.sendEmail(request);
            logger.info("E-mail enviado com sucesso para: {}", toEmail);
        } catch (SesException e) {
            logger.error("Erro ao enviar o e-mail para: {}", toEmail, e);
            throw new RuntimeException("Falha ao enviar o e-mail.", e);
        }
    }
}
