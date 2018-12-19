package com.sutse.team21.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
public class PlaceReserve {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long placeId;
    private String placeName;
    private String placeAddress;

    protected PlaceReserve() {}
}