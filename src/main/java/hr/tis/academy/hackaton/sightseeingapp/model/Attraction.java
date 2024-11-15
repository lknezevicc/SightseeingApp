package hr.tis.academy.hackaton.sightseeingapp.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name="ATTRACTION",schema = "SIGHTSEEING_APP")
public class Attraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    @NotBlank
    private String description;

    @Column
    private String type;

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID", nullable = false)
    private Location location;

    @ManyToMany(mappedBy = "favouriteAttractions")
    private List<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}