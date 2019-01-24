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
@Table(name = "AgencyType")
public class AgencyTypeEntity {
    @Id
    @SequenceGenerator(name="agency_seq",sequenceName="agency_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="agency_seq")
    @Column(name="AGENCY_ID",unique = true, nullable = false)

    private @NonNull Long agencyID;
    private @NonNull String agencyName;

    public AgencyTypeEntity(){}

    public Long getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(Long agencyID) {
        this.agencyID = agencyID;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }
}
