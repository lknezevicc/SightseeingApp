package hr.tis.academy.hackaton.sightseeingapp.service.impl;

import hr.tis.academy.hackaton.sightseeingapp.model.Attraction;
import hr.tis.academy.hackaton.sightseeingapp.model.Review;
import hr.tis.academy.hackaton.sightseeingapp.repository.AttractionRepository;
import hr.tis.academy.hackaton.sightseeingapp.repository.ReviewRepository;
import hr.tis.academy.hackaton.sightseeingapp.requestDto.ReviewRequestDto;
import hr.tis.academy.hackaton.sightseeingapp.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final AttractionRepository attractionRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, AttractionRepository attractionRepository) {
        this.reviewRepository = reviewRepository;
        this.attractionRepository = attractionRepository;
    }

    @Override
    public boolean addReview(ReviewRequestDto reviewRequestDto) {
        Optional<Attraction> attraction =
                Optional.ofNullable(attractionRepository.findAttractionByNameAndLocationName(reviewRequestDto.attractionName(), reviewRequestDto.locationName()));

        if (attraction.isPresent()) {
            Review review = new Review(reviewRequestDto.timestamp(), reviewRequestDto.rating(), reviewRequestDto.reviewText(), attraction.get());
            reviewRepository.save(review);
            return true;
        } else {
            return false;
        }
    }
}
