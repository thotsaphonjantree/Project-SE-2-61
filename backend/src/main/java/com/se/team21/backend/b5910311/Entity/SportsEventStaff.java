package com.se.team21.backend.b5910311.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import lombok.Data;
import lombok.NonNull;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "SportsEventStaff")
public class SportsEventStaff {
    @Id
    @SequenceGenerator(name = "sportseventstaff_seq", sequenceName = "sportseventstaff_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sportseventstaff_seq")
    @Column(name="sportseventstaff_seq_ID",unique = true, nullable = true)
    private @NonNull Long sesid;
    @NotNull(message="sportname must not be null to be valid")
    private String sesname;

    public SportsEventStaff() {
    }

    public SportsEventStaff(Long sesid,String sesname) {
        this.sesid = sesid;
        this.sesname = sesname;
    }
    public String getSesName() {
        return sesname;
    }
    public void setSesName(String sesname) {
        this.sesname = sesname;
    }
    public void setSESid(Long sesid) {
        this.sesid = sesid;
    }
    public Long getSESid() {
        return sesid;
    }
       

}