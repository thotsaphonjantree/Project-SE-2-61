package com.se.team21.backend.AnanB5911417.Entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class ReservePlace {

    @Id
    @SequenceGenerator(name = "ReservePlace_seq", sequenceName = "ReservePlace_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ReservePlace_seq")
    private @NonNull Long reserveId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sportEventForId")
    private SportEvent sportEventF;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "placeEventForId")
    private PlaceEvent placeEventF;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "StaffForId")
    private Staff staffF;


}