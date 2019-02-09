package com.se.team21.backend.AnanB5911417.sp2.Entity;

import javax.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class StoreType {

    @Id
    @SequenceGenerator(name = "StoreType_seq", sequenceName = "StoreType_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "StoreType_seq")


    private @NonNull Long typeId;
    private @NonNull String typeName;

}