package com.se.team21.backend.Entity;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;


@Data
@Entity
@Table(name = "Padstatus")

public class Paidstatus {
    @Id
    @SequenceGenerator(name = "paidstatus_seq", sequenceName = "paidstatus_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paidstatus_seq")
    private @NonNull Long id;
}
