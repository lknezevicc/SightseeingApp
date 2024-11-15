package hr.tis.academy.hackaton.sightseeingapp.service.impl;

import hr.tis.academy.hackaton.sightseeingapp.dto.AttractionDto;
import hr.tis.academy.hackaton.sightseeingapp.dto.AttractionWithReviewDto;
import hr.tis.academy.hackaton.sightseeingapp.dto.ReviewDto;
import hr.tis.academy.hackaton.sightseeingapp.mappers.AttractionMapper;
import hr.tis.academy.hackaton.sightseeingapp.mappers.ReviewMapper;
import hr.tis.academy.hackaton.sightseeingapp.repository.AttractionRepository;
import hr.tis.academy.hackaton.sightseeingapp.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttractionServiceImpl implements AttractionService {
    private final AttractionRepository attractionRepository;
    private final AttractionMapper attractionMapper=AttractionMapper.INSTANCE;
    private final ReviewMapper reviewMapper = ReviewMapper.INSTANCE;

    @Autowired
    public AttractionServiceImpl(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }


    @Override
    public List<AttractionDto> FindAttractionsByLocation(String locationName) {
        return attractionRepository.findAttractionByLocation(locationName)
                .stream().map(attractionMapper::toDto)
                .toList();
    }

    @Override
    public AttractionDto FindAttractionsByLocationAndName(String LocationName, String Name) {
        return attractionMapper.toDto(attractionRepository.findAttractionByNameAndLocationName(Name, LocationName));
    }
    @Override
    public AttractionWithReviewDto GetAttractionDetails(String LocationName, String Name, Boolean excludeReviews, Integer reviewsFrom, Integer reviewsTo){
        List<ReviewDto> reviews = attractionRepository.getReviewsByAttraction(attractionRepository.findAttractionByNameAndLocationName(Name, LocationName)).stream().map(reviewMapper::toDto)
                .toList();
        reviews.forEach(System.out::println);
        AttractionDto attractionDto=FindAttractionsByLocationAndName(LocationName,Name);


        if(reviewsFrom != null && reviewsTo != null && reviewsFrom < reviewsTo && reviews.size() > 3) {
            return new AttractionWithReviewDto(attractionDto.description(),attractionDto.type(),reviews.subList(reviewsTo-1,reviewsFrom-1));
        }
        else {
            return new AttractionWithReviewDto(attractionDto.description(),attractionDto.type(),reviews);
        }

    }
}
