package com.se.team21.backend.Entity;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;


@Data
@Entity
@Table(name = "TestEntity")

public class TestEntity {
    @Id
    @SequenceGenerator(name = "testentity_seq", sequenceName = "testentity_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "testentity_seq")
    private @NonNull Long id;
}
