package com.se.team21.backend.Entity;

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


}