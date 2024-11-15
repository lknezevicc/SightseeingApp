package hr.tis.academy.hackaton.sightseeingapp.controller;

import hr.tis.academy.hackaton.sightseeingapp.dto.AttractionDto;
import hr.tis.academy.hackaton.sightseeingapp.dto.AttractionWithReviewDto;
import hr.tis.academy.hackaton.sightseeingapp.mappers.AttractionMapper;
import hr.tis.academy.hackaton.sightseeingapp.repository.AttractionRepository;
import hr.tis.academy.hackaton.sightseeingapp.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attractions")
public class AttractionController {
    private final AttractionService attractionService;
    private final AttractionMapper attractionMapper = AttractionMapper.INSTANCE;
    private final AttractionRepository attractionRepository;

    @Autowired
    public AttractionController(AttractionService attractionService, AttractionRepository attractionRepository) {
        this.attractionService = attractionService;
        this.attractionRepository = attractionRepository;
    }

    @GetMapping("/{locationName}")
    public ResponseEntity<List<AttractionDto>> findAttractionsByLocation(@PathVariable String locationName) {
        return attractionService.FindAttractionsByLocation(locationName) == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(attractionService.FindAttractionsByLocation(locationName));
    }

    @GetMapping("/{locationName}/{attractionURLName}")
    public ResponseEntity<?> findAttractionByLocationAndName(@PathVariable String locationName, @PathVariable String attractionURLName, @RequestParam(name = "excludeReviews", required = false, defaultValue = "false") Boolean excludeReviews, @RequestParam(name = "reviewsFrom", required = false, defaultValue = "1") Integer reviewsFrom, @RequestParam(name = "reviewsTo", defaultValue = "3", required = false) Integer reviewsTo) {
        AttractionWithReviewDto ar = attractionService.GetAttractionDetails(locationName, attractionURLName, excludeReviews, reviewsFrom, reviewsTo);
        if (ar == null) {
            return ResponseEntity.notFound().build();
        }
        if (excludeReviews) {
            AttractionDto ad = new AttractionDto(null, ar.description(), ar.type());
            return ResponseEntity.ok(ad);
        }
        return attractionService.GetAttractionDetails(locationName, attractionURLName, excludeReviews, reviewsFrom, reviewsTo) == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(attractionService.GetAttractionDetails(locationName, attractionURLName, excludeReviews, reviewsFrom, reviewsTo));
    }

}
