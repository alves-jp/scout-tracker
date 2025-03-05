package com.scout_tracker.domain.exception;

public class ApiRateLimitExceededException extends RuntimeException {
    public ApiRateLimitExceededException(String message) {
        super(message);
    }
}