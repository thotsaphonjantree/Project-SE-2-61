package com.se.team21.backend.b5910311.entity;

import lombok.Data;
import lombok.NonNull;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NonNull;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Data
@Entity
@Table(name = "SportsType")
public class SportsType {
    @Id
    @SequenceGenerator(name = "sportstype_seq", sequenceName = "sportstype_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sportstype_seq")
    @Column(name="SportsType_ID",unique = true, nullable = true)
    private @NonNull Long stid;
    @NotNull(message="sportname must not be null to be valid")
    private String sportname;

    public SportsType() {
    }

    public SportsType(Long stid,String sportname) {
        this.stid = stid;
        this.sportname = sportname;
    }
    public String getSportName() {
        return sportname;
    }
    public void setSportName(String sportname) {
        this.sportname = sportname;
    }
    public void setSTid(Long stid) {
        this.stid = stid;
    }
    public Long getSTid() {
        return stid;
    }
    
    
}