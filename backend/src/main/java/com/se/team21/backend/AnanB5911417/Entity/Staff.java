package com.se.team21.backend.Entity;


import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Staff {

    @Id
    @SequenceGenerator(name = "Staff_seq", sequenceName = "Staff_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Staff_seq")
    private Long staffId;
    private String staffName;



}