package com.se.team21.backend.b5910311.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Profile")
public class Profile {
    @Id
    @SequenceGenerator(name = "address_seq", sequenceName = "address_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @Column(name="Profile_ID",unique = true, nullable = true)
    private @NonNull Long pid;
    private @NonNull String firstname;
    private @NonNull String lastname;

    public Profile() {
    }

    public Profile(Long pid,String lastname,String firstname) {
        this.pid = pid;
        this.lastname = lastname;
        this.firstname = firstname;
    }
    public String getLastName() {
        return lastname;
    }
    public void setLastName(String lastname) {
        this.lastname = lastname;
    }
    public String getFirstName() {
        return firstname;
    }
    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }  
    public void setPid(Long pid) {
        this.pid = pid;
    }
    public Long getPid() {
        return pid;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "P_A")
    private Address addressname;
}