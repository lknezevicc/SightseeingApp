package hr.tis.academy.hackaton.sightseeingapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "LOCATION",schema = "SIGHTSEEING_APP")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
