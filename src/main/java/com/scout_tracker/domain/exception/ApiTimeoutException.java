package com.scout_tracker.domain.exception;

public class ApiTimeoutException extends RuntimeException {

    public ApiTimeoutException(String message) {
        super(message);
    }
}