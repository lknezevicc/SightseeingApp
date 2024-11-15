package hr.tis.academy.hackaton.sightseeingapp.service;

import hr.tis.academy.hackaton.sightseeingapp.model.User;
import hr.tis.academy.hackaton.sightseeingapp.dto.FavoriteAttractionDto;

import java.util.List;

public interface UserService {
    boolean checkIfUserExists(String email);
    boolean checkIfUserExists(Long userId);
    User saveUser(User user);
    User getUser(Long userId);
    User addFavouriteAttraction(Long userId, FavoriteAttractionDto attraction);
    List<FavoriteAttractionDto> getUserFavouriteAttractions(Long userId);
}
