package com.se.team21.backend.b5910311.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;
import lombok.*;


@Data
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "Profile")
public class Profile {
    @Id
    @SequenceGenerator(name = "profile_seq", sequenceName = "profile_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_seq")
    @Column(name="Profile_ID",unique = true, nullable = true)
    @NotNull
    private Long pid;
    @NotNull(message="firstname must not be null to be valid")
    private String firstname;
    @NotNull(message="lastname must not be null to be valid")
    private String lastname;

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
    @NotNull(message="addressname must not be null to be valid")
    private Address addressname;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "P_M")
    @NotNull(message="name must not be null to be valid")
    private com.se.team21.backend.B5926329.Entity.Member name;
}