package com.se.team21.backend.AnanB5911417.Entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class PlaceEvent {

    @Id
    @SequenceGenerator(name = "PlaceEvent_seq", sequenceName = "PlaceEvent_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PlaceEvent_seq")


    private @NonNull Long placeId;
    @Column(unique = true)
    private @NotNull (message="placeName must not be null to be valid")
    String placeName;
    private @NotNull (message="placeAddress must not be null to be valid")
    String placeAddress;
    @Size(max = 10, min = 10)
    @Pattern(regexp = "[0-9]*")
    private @NotNull String placeTel;
}