package hr.tis.academy.hackaton.sightseeingapp.service;

import hr.tis.academy.hackaton.sightseeingapp.requestDto.ReviewRequestDto;

public interface ReviewService {
    boolean addReview(ReviewRequestDto reviewRequestDto);
}
