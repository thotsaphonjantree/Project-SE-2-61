package com.se.team21.backend.B5909711.Entity;

import lombok.*;
import com.se.team21.backend.b5910311.entity.SportsEvent;
import javax.persistence.*;
import java.util.Date;

// import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "RelatedInformation")
public class RelatedInformationEntity {
    @Id
    @SequenceGenerator(name="related_seq",sequenceName="related_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="related_seq")
    @Column(name="RELATED_ID",unique = true, nullable = false)
    private @NonNull Long relatedinformationID;
    private @NonNull String relatedinformationName;
    private @NonNull String relatedinformationAddress;
    @Temporal(TemporalType.DATE)
    private @NonNull Date relatedinformationDate;
    private @NonNull String relatedinformationPhone;
    private @NonNull String relatedinformationEmail;

    //Many To One with SportsEvent
    @ManyToOne /*(fetch = FetchType.EAGER, targetEntity = AgencyTypeEntity.class)*/
    @JoinColumn(name = "seid")
    private SportsEvent sportsEvent;

    //Many To One with AgencyType
    @ManyToOne /*(fetch = FetchType.EAGER, targetEntity = AgencyTypeEntity.class)*/
    @JoinColumn(name = "agencyID")
    private AgencyTypeEntity agencyTypeEntity;

    //Many To One with Country
    @ManyToOne /*(fetch = FetchType.EAGER, targetEntity = CountryEntity.class)*/
    @JoinColumn(name = "countryID")
    private CountryEntity countryEntity;

    //Many To One with Province
    @ManyToOne /*(fetch = FetchType.EAGER, targetEntity = ProvinceEntity.class)*/
    @JoinColumn(name = "provinceID")
    private ProvinceEntity provinceEntity;

    public Long getRelatedinformationID() {
        return relatedinformationID;
    }

    public void setRelatedinformationID(Long relatedinformationID) {
        this.relatedinformationID = relatedinformationID;
    }

    public String getRelatedinformationName() {
        return relatedinformationName;
    }

    public void setRelatedinformationName(String relatedinformationName) {
        this.relatedinformationName = relatedinformationName;
    }

    public String getRelatedinformationAddress() {
        return relatedinformationAddress;
    }

    public void setRelatedinformationAddress(String relatedinformationAddress) {
        this.relatedinformationAddress = relatedinformationAddress;
    }

    public String getRelatedinformationPhone() {
        return relatedinformationPhone;
    }

    public void setRelatedinformationPhone(String relatedinformationPhone) {
        this.relatedinformationPhone = relatedinformationPhone;
    }

    public String getRelatedinformationEmail() {
        return relatedinformationEmail;
    }

    public void setRelatedinformationEmail(String relatedinformationEmail) {
        this.relatedinformationEmail = relatedinformationEmail;
    }

    public void setRelatedinformationDate(Date relatedinformationDate){
        this.relatedinformationDate = relatedinformationDate;
    }

    public Date getRelatedinformationDate(){
        return this.relatedinformationDate;
    }

    public AgencyTypeEntity getAgencyTypeEntity() {
        return agencyTypeEntity;
    }

    public void setAgencyTypeEntity(AgencyTypeEntity agencyTypeEntity) {
        this.agencyTypeEntity = agencyTypeEntity;
    }

    public CountryEntity getCountryEntity() {
        return countryEntity;
    }

    public void setCountryEntity(CountryEntity countryEntity) {
        this.countryEntity = countryEntity;
    }

    public ProvinceEntity getProvinceEntity() {
        return provinceEntity;
    }

    public void setProvinceEntity(ProvinceEntity provinceEntity) {
        this.provinceEntity = provinceEntity;
    }

	public Object map(Object object) {
		return null;
	}

    public SportsEvent getSportsEvent() {
        return sportsEvent;
    }

    public void setSportsEvent(SportsEvent sportsEvent) {
        this.sportsEvent = sportsEvent;
    }
}
