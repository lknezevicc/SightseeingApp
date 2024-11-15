package hr.tis.academy.hackaton.sightseeingapp.controller;

import hr.tis.academy.hackaton.sightseeingapp.dto.UserDto;
import hr.tis.academy.hackaton.sightseeingapp.mappers.UserMapper;
import hr.tis.academy.hackaton.sightseeingapp.model.User;
import hr.tis.academy.hackaton.sightseeingapp.dto.FavoriteAttractionDto;
import hr.tis.academy.hackaton.sightseeingapp.response.BadResponse;
import hr.tis.academy.hackaton.sightseeingapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody UserDto user) {
        if (userService.checkIfUserExists(user.email())) {
            return ResponseEntity.badRequest().body(new BadResponse("User with email " + user.email() + " already exists"));
        }

        User savedUser = userService.saveUser(userMapper.toEntity(user));
        return savedUser == null ? ResponseEntity.badRequest()
                .body(new BadResponse("User not saved")) : ResponseEntity.created(URI.create("/user/" + savedUser.getId())).build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Long userId) {
        User user = userService.getUser(userId);

        return user == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(userMapper.toDto(user));
    }

    @PostMapping("/{userId}/favourites")
    public ResponseEntity<?> addFavouriteAttraction(@PathVariable Long userId, @Valid @RequestBody FavoriteAttractionDto favoriteAttractionDto) {
        if (!userService.checkIfUserExists(userId)) {
            return ResponseEntity.badRequest().body(new BadResponse("User with id " + userId + " does not exist"));
        }

        Optional<User> user = Optional.ofNullable(userService.addFavouriteAttraction(userId, favoriteAttractionDto));
        return user.isEmpty() ? ResponseEntity.badRequest().body(new BadResponse("Attraction not added")) :
                ResponseEntity.created(URI.create("/user/" + userId + "/favourites")).build();
    }

    @GetMapping("/{userId}/favourites")
    public ResponseEntity<?> getFavouriteAttractions(@PathVariable Long userId) {
        if (!userService.checkIfUserExists(userId)) {
            return ResponseEntity.badRequest().body(new BadResponse("User with id " + userId + " does not exist"));
        }

        List<FavoriteAttractionDto> favouriteAttractions = userService.getUserFavouriteAttractions(userId);

        return favouriteAttractions.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(favouriteAttractions);
    }

}
