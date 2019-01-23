package com.se.team21.backend.b5910311.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SeSt")
public class SeSt {
    @Id
    @SequenceGenerator(name = "sest_seq", sequenceName = "sest_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sest_seq")
    @Column(name="Sest_ID",unique = true, nullable = true)
    private @NonNull Long id;

    public SeSt() {
    }

    public SeSt(Long id) {
        this.id = id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ST_ID")
    private SportsType SportName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SE_ID")
    private SportsEvent EventName;

}