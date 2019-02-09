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
@ToString
@EqualsAndHashCode
@Table(name = "Address")
public class Address {
    @Id
    @SequenceGenerator(name = "address_seq", sequenceName = "address_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @Column(name="Address_ID",unique = true, nullable = true)
    private @NonNull Long aid;

    @Size(max = 5, min = 5)
    @Pattern(regexp = "[0-9]*")
    @Column(unique = true)
    @NotNull(message="code must not be null to be valid")
    private String code;

    @NotNull(message="addressname must not be null to be valid")
    private String addressname;

    public Address() {
    }

    public Address(Long aid,String addressname,String code) {
        this.aid = aid;
        this.code = code;
        this.addressname = addressname;
    }
    public String getAddressname() {
        return addressname;
    }
    public void setAddressname(String addressname) {
        this.addressname = addressname;
    }  
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    } 
    public void setAid(Long aid) {
        this.aid = aid;
    }
    public Long getAid() {
        return aid;
    }

}