package com.se.team21.backend.B5901890.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name="KindSportMedia")
@ToString
@Getter @Setter
@EqualsAndHashCode
public class KindSportMedia {
    @Id
    @SequenceGenerator(name="KindSportMedia_seq",sequenceName="KindSportMedia_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="KindSportMedia_seq")
    @Column(name="KindSportMedia_Id",unique = true, nullable = false)

    private @NotNull Long id_Sport;

    private @NotNull (message="kind_Sport must not be null to be valid")
    @NonNull String kind_Sport;

    public Long getId_Sport() {
        return id_Sport;
    }

    public void setId_Sport(Long id_Sport) {
        this.id_Sport = id_Sport;
    }

    public String getKind_Sport() {
        return kind_Sport;
    }

    public void setKind_Sport(String kind_Sport) {
        this.kind_Sport = kind_Sport;
    }

    public KindSportMedia(){}

}
