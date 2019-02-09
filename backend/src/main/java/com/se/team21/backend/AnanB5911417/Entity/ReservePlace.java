package com.se.team21.backend.AnanB5911417.Entity;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;


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
    @Temporal(TemporalType.DATE)
    private @NotNull (message="Sdate must not be null to be valid")
     Date Sdate;
    @Temporal(TemporalType.DATE)
    private @NotNull (message="Edate must not be null to be valid")
     Date Edate;

     @ManyToOne(fetch = FetchType.EAGER)
     @JoinColumn(name = "sportEventForId")
     @NotNull
    private com.se.team21.backend.b5910311.entity.SportsEvent sportEventF;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "placeEventForId")
    @NotNull
    private PlaceEvent placeEventF;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "StaffForId")
    @NotNull
    private com.se.team21.backend.B5901890.Entity.RegisterStaff staffF;


}