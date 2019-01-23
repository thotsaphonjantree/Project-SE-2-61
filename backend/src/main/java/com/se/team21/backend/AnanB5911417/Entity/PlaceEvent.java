package com.se.team21.backend.AnanB5911417.Entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class PlaceEvent {

    @Id
    @SequenceGenerator(name = "PlaceEvent_seq", sequenceName = "PlaceEvent_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PlaceEvent_seq")


    private Long placeId;
    private String placeName;
    private String placeAddress;
    
}