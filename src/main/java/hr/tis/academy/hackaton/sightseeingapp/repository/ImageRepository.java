package hr.tis.academy.hackaton.sightseeingapp.repository;

import hr.tis.academy.hackaton.sightseeingapp.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
