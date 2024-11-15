package hr.tis.academy.hackaton.sightseeingapp.repository;

import hr.tis.academy.hackaton.sightseeingapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
