package hr.tis.academy.hackaton.sightseeingapp.mappers;

import hr.tis.academy.hackaton.sightseeingapp.dto.LocationDto;
import hr.tis.academy.hackaton.sightseeingapp.dto.ReviewDto;
import hr.tis.academy.hackaton.sightseeingapp.model.Location;
import hr.tis.academy.hackaton.sightseeingapp.model.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReviewMapper {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    //@Mapping(target = "attractions",ignore = true)
    ReviewDto toDto(Review review);
    //Review toEntity(ReviewDto reviewDto);
}
