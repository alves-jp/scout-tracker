package com.scout_tracker.domain.exception;

public class ApiCommunicationException extends RuntimeException {

    public ApiCommunicationException(String message) {
        super(message);
    }
}