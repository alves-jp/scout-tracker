package com.scout_tracker.config;

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
    public S3Client s3Client() {
        return S3Client.builder()
                .region(Region.of(getRegion()))
                .build();
    }

    @Override
    public String getImageBucketName() {
        return "my-image-bucket";
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