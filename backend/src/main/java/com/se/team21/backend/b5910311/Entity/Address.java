package com.se.team21.backend.b5910311.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Address")
public class Address {
    @Id
    @SequenceGenerator(name = "address_seq", sequenceName = "address_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @Column(name="Address_ID",unique = true, nullable = true)
    private @NonNull Long aid;
    private @NonNull String addressname;

    public Address() {
    }

    public Address(Long aid,String addressname) {
        this.aid = aid;
        this.addressname = addressname;
    }
    public String getAddress() {
        return addressname;
    }
    public void setAddress(String addressname) {
        this.addressname = addressname;
    }  
    public void setAid(Long aid) {
        this.aid = aid;
    }
    public Long getAid() {
        return aid;
    }

}