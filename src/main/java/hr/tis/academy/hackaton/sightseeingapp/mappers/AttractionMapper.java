package hr.tis.academy.hackaton.sightseeingapp.mappers;

import hr.tis.academy.hackaton.sightseeingapp.dto.AttractionDto;
import hr.tis.academy.hackaton.sightseeingapp.model.Attraction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AttractionMapper {
    AttractionMapper INSTANCE = Mappers.getMapper(AttractionMapper.class);

    AttractionDto toDto(Attraction attraction);
//    @Mapping(target = "name",ignore = true)
//    Attraction toEntity(AttractionDto attractionDto);
}