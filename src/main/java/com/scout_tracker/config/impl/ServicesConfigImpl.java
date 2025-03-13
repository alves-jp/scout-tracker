package com.scout_tracker.config.impl;

import com.scout_tracker.config.ServicesConfig;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.ses.SesClient;

@Configuration
public class ServicesConfigImpl implements ServicesConfig {

    @Override
    public String getRegion() {
        return "sa-east-1";
    }

    @Override
    public String getNotificationSenderEmail() {
        return "no-reply@example.com";
    }

    @Override
    public SesClient sesClient() {
        return SesClient.builder()
                .region(Region.of(getRegion()))
                .build();
    }
}