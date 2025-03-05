package com.scout_tracker.config;

import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.ses.SesClient;

@Configuration
public interface ServicesConfig {
    public String getRegion();

    public S3Client s3Client();

    public String getImageBucketName();

    public String getNotificationSenderEmail();

    public SesClient sesClient();
}