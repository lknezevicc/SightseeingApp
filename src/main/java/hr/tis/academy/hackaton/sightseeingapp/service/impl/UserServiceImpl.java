package hr.tis.academy.hackaton.sightseeingapp.service.impl;

import hr.tis.academy.hackaton.sightseeingapp.model.Attraction;
import hr.tis.academy.hackaton.sightseeingapp.model.User;
import hr.tis.academy.hackaton.sightseeingapp.repository.AttractionRepository;
import hr.tis.academy.hackaton.sightseeingapp.repository.UserRepository;
import hr.tis.academy.hackaton.sightseeingapp.dto.FavoriteAttractionDto;
import hr.tis.academy.hackaton.sightseeingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AttractionRepository attractionRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AttractionRepository attractionRepository) {
        this.userRepository = userRepository;
        this.attractionRepository = attractionRepository;
    }

    @Override
    public boolean checkIfUserExists(String email) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));
        return user.isPresent();
    }

    @Override
    public boolean checkIfUserExists(Long userId) {
        Optional<User> user = Optional.ofNullable(userRepository.findUserById(userId));
        return user.isPresent();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long userId) {
        return userRepository.findUserById(userId);
    }

    @Override
    public User addFavouriteAttraction(Long userId, FavoriteAttractionDto attraction) {
        Optional<User> user = Optional.ofNullable(userRepository.findUserById(userId));
        if (user.isEmpty()) return null;

        Optional<Attraction> tempAttraction = Optional.ofNullable(attractionRepository.findAttractionByNameAndLocationName(attraction.attractionName(), attraction.location()));
        if (tempAttraction.isEmpty()) return null;

        User tempUser = user.get();
        tempUser.addFavouriteAttraction(tempAttraction.get());
        userRepository.save(tempUser);
        return tempUser;
    }

    @Override
    public List<FavoriteAttractionDto> getUserFavouriteAttractions(Long userId) {
        List<Attraction> attractions = userRepository.fetchFavouriteAttractions(userId);
        if (attractions.isEmpty()) return new ArrayList<>();

        return attractions.stream().map(attraction -> new FavoriteAttractionDto(attraction.getName(), attraction.getLocation().getName())).toList();
    }


}
