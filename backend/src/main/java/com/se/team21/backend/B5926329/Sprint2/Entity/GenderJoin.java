package com.se.team21.backend.B5926329.Sprint2.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Genders")
public class GenderJoin {
    @Id
    @SequenceGenerator(name = "gender_seq", sequenceName = "gender_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gender_seq")
    @NotNull
    private  Long genderId;

    @NotNull (message="genderName must not be null to be valid")
    private String genderName;

}
