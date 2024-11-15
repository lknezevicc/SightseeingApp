package hr.tis.academy.hackaton.sightseeingapp.repository;

import hr.tis.academy.hackaton.sightseeingapp.dto.AttractionDto;
import hr.tis.academy.hackaton.sightseeingapp.model.Attraction;
import hr.tis.academy.hackaton.sightseeingapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Long> {
    @Query("SELECT a FROM  Attraction a JOIN a.location l WHERE l.name=:locationName")
    List<Attraction> findAttractionByLocation(String locationName);

    @Query("SELECT a FROM Attraction a WHERE a.name=:attractionName AND a.location.name=:locationName")
    Attraction findAttractionByNameAndLocationName(String attractionName, String locationName);

    @Query("SELECT r FROM Review r WHERE r.attraction.name=:#{#attraction.name}")
    List<Review> getReviewsByAttraction(Attraction attraction);

}