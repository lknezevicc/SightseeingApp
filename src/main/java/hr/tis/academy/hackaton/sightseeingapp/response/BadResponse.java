package hr.tis.academy.hackaton.sightseeingapp.response;

import java.time.LocalDateTime;

public record BadResponse(String message, LocalDateTime timestamp) {
    public BadResponse(String message) {
        this(message, LocalDateTime.now());
    }
}
