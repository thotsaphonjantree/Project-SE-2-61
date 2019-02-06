package com.se.team21.backend.AnanB5911417.sp2.Entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class StoreType {

    @Id
    @SequenceGenerator(name = "EventStore_seq", sequenceName = "EventStore_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EventStore_seq")


    private @NonNull Long typeId;
    private @NonNull String typeName;

}