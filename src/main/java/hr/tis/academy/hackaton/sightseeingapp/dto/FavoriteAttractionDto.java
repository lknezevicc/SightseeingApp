package hr.tis.academy.hackaton.sightseeingapp.dto;

import jakarta.validation.constraints.NotBlank;

public record FavoriteAttractionDto(
        @NotBlank
        String location,
        @NotBlank
        String attractionName) {
}
