package hr.tis.academy.hackaton.sightseeingapp.service;

import hr.tis.academy.hackaton.sightseeingapp.dto.AttractionDto;
import hr.tis.academy.hackaton.sightseeingapp.dto.AttractionWithReviewDto;
import hr.tis.academy.hackaton.sightseeingapp.model.Attraction;

import java.util.List;

public interface AttractionService {
    List<AttractionDto> FindAttractionsByLocation(String LocationName);
    AttractionDto FindAttractionsByLocationAndName(String LocationName, String Name);
    AttractionWithReviewDto GetAttractionDetails(String LocationName, String Name, Boolean excludeReviews, Integer reviewsFrom, Integer reviewsTo);
}
