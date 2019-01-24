package com.se.team21.backend.B5909711.Entity;

import lombok.*;

import javax.persistence.*;

// import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@Getter @Setter
//@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Country")
public class CountryEntity {
    @Id
    @SequenceGenerator(name="country_seq",sequenceName="country_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="country_seq")
    @Column(name="COUNTRY_ID",unique = true, nullable = false)

    private @NonNull Long countryID;
    private @NonNull String countryName;

    public CountryEntity(){}

    public Long getCountryID() {
        return countryID;
    }

    public void setCountryID(Long countryID) {
        this.countryID = countryID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
