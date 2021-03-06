package com.se.team21.backend.b5910311.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "Location")
public class Location {
    @Id
    @SequenceGenerator(name = "location_seq", sequenceName = "location_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_seq")
    @Column(name="Location_ID",unique = true, nullable = true)
    private @NonNull Long lid;
    @Size(max = 20, min = 5)
    @Pattern(regexp = "[A-Z |a-z]*")
    @NotNull(message="locations must not be null to be valid")
    private String locations;

    public Location() {
    }

    public Location(Long lid,String locations) {
        this.lid = lid;
        this.locations = locations;
    }
    public String getLocations() {
        return locations;
    }
    public void setLocations(String locations) {
        this.locations = locations;
    }  
    public void setLid(Long lid) {
        this.lid = lid;
    }
    public Long getLid() {
        return lid;
    }

}