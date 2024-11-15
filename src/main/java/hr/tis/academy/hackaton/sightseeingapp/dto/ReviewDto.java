package hr.tis.academy.hackaton.sightseeingapp.dto;

import java.time.LocalDateTime;

public record ReviewDto(
        LocalDateTime timestamp,
        double rating,
        String reviewText
) {
}
