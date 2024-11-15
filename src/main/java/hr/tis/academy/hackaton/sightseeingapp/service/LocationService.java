package hr.tis.academy.hackaton.sightseeingapp.service;

import hr.tis.academy.hackaton.sightseeingapp.dto.LocationDto;
import hr.tis.academy.hackaton.sightseeingapp.model.Location;

import java.util.List;

public interface LocationService {
    List<LocationDto> findAll();
    LocationDto findByName(String name);
    LocationDto save(LocationDto locationDto);
}
