package com.practice.exceptions;

public class VideoJuegoNotFoundException extends RuntimeException {
    public VideoJuegoNotFoundException(String message) {
        super(message);
    }
}
