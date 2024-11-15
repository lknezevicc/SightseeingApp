package hr.tis.academy.hackaton.sightseeingapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS", schema = "SIGHTSEEING_APP")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    private String name;

    @Column
    @Email
    @NotBlank
    private String email;

    @ManyToMany
    @JoinTable(
            name = "USER_FAVOURITE_ATTRACTIONS",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ATTRACTION_ID"),
            schema = "SIGHTSEEING_APP"
    )
    private List<Attraction> favouriteAttractions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @Email @NotBlank String getEmail() {
        return email;
    }

    public void setEmail(@Email @NotBlank String email) {
        this.email = email;
    }

    public List<Attraction> getFavouriteAttractions() {
        return favouriteAttractions;
    }

    public void setFavouriteAttractions(List<Attraction> favouriteAttractions) {
        this.favouriteAttractions = favouriteAttractions;
    }

    public void addFavouriteAttraction(Attraction attraction) {
        if (this.favouriteAttractions == null) {
            this.favouriteAttractions = new ArrayList<>();
        }
        this.favouriteAttractions.add(attraction);
    }
}
