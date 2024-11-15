package hr.tis.academy.hackaton.sightseeingapp.controller;

import hr.tis.academy.hackaton.sightseeingapp.requestDto.ReviewRequestDto;
import hr.tis.academy.hackaton.sightseeingapp.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attraction")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/review")
    public ResponseEntity<?> addReview(@Valid @RequestBody ReviewRequestDto reviewRequestDto) {
        boolean reviewAdded = reviewService.addReview(reviewRequestDto);

        if (reviewAdded) return new ResponseEntity<>(HttpStatus.CREATED);
        else return ResponseEntity.notFound().build();
    }
}
