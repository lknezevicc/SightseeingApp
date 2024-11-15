package hr.tis.academy.hackaton.sightseeingapp.repository;

import hr.tis.academy.hackaton.sightseeingapp.model.Attraction;
import hr.tis.academy.hackaton.sightseeingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findUserById(Long id);

    @Query("SELECT u.favouriteAttractions FROM User u WHERE u.id=:id")
    List<Attraction> fetchFavouriteAttractions(Long id);
}
