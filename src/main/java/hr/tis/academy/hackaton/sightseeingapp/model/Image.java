package hr.tis.academy.hackaton.sightseeingapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "IMAGE", schema = "SIGHTSEEING_APP")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(length = 1000)
    private byte[] imageData;

    @ManyToOne
    @JoinColumn(name = "ATTRACTION_ID", nullable = false)
    private Attraction attraction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }
}
