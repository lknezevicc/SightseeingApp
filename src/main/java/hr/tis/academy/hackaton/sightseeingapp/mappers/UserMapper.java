package hr.tis.academy.hackaton.sightseeingapp.mappers;

import hr.tis.academy.hackaton.sightseeingapp.dto.UserDto;
import hr.tis.academy.hackaton.sightseeingapp.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "favouriteAttractions", ignore = true)
    User toEntity(UserDto userDto);
}
