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
    private @NonNull String address;

    public Address() {
    }

    public Address(Long aid,String address) {
        this.aid = aid;
        this.address = address;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }  
    public void setAid(Long aid) {
        this.aid = aid;
    }
    public Long getAid() {
        return aid;
    }

}