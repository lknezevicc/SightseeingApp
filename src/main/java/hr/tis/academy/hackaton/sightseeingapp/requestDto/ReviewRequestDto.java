package hr.tis.academy.hackaton.sightseeingapp.requestDto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ReviewRequestDto(
        @NotBlank String locationName,
        @NotBlank String attractionName,
        @NotNull LocalDateTime timestamp,
        @NotNull @Min(1) @Max(5) Double rating,
        @NotBlank String reviewText
) {
}
