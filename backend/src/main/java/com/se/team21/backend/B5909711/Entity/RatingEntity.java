package com.se.team21.backend.B5909711.Entity;
import lombok.*;
import javax.persistence.*;

@Entity
@Data
@Getter @Setter
//@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Rating")
public class RatingEntity {
    @Id
    @SequenceGenerator(name="rating_seq",sequenceName="rating_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="rating_seq")
    @Column(name="RATING_ID",unique = true, nullable = false)
    private @NonNull Long rID;
    private @NonNull String ratingName;

    public RatingEntity() {}

    public String getRatingName() {
        return ratingName;
    }

    public void setRatingName(String ratingName) {
        this.ratingName = ratingName;
    }

    public Long getrID() {
        return rID;
    }

    public void setrID(Long rID) {
        this.rID = rID;
    }
}
