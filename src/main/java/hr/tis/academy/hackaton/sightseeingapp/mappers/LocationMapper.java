package hr.tis.academy.hackaton.sightseeingapp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LocationMapper {
    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

//    @Mapping(target = "attractions",ignore = true)
//    LocationDto toDto(Location location);
//    Location toEntity(LocationDto locationDto);
}
