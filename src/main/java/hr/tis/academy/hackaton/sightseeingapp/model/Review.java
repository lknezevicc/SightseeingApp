package hr.tis.academy.hackaton.sightseeingapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name="REVIEW",schema = "SIGHTSEEING_APP")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime timestamp;

    @Column
    private Double rating;

    @Column
    private String reviewText;

    @ManyToOne
    @JoinColumn(name = "ATTRACTION_ID", nullable = false)
    private Attraction attraction;

    public Review() {}

    public Review(LocalDateTime timestamp, Double rating, String reviewText, Attraction attraction) {
        this.timestamp = timestamp;
        this.rating = rating;
        this.reviewText = reviewText;
        this.attraction = attraction;
    }


    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public void setRating(@NotNull @Min(1) @Max(5) Double rating) {
        this.rating = rating;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }
}
