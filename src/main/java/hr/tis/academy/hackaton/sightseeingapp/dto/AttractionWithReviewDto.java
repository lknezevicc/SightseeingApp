package hr.tis.academy.hackaton.sightseeingapp.dto;

import java.util.List;

public record AttractionWithReviewDto(
        String description,
        String type,
        List<ReviewDto> reviews
) {
}
