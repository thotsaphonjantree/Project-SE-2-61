package com.se.team21.backend.B5909711.Entity;
import lombok.*;
import com.se.team21.backend.b5910311.entity.SportsEvent;
import com.se.team21.backend.b5910311.entity.SportsType;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Result")
public class ResultEntity {
    @Id
    @SequenceGenerator(name="result_seq",sequenceName="result_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="result_seq")
    @Column(name="resultID",unique = true, nullable = false)
    private @NonNull Long resultID;
    private @NonNull String resultName;
    @Temporal(TemporalType.DATE)
    private @NonNull Date resultDate;
    private @NonNull String resultAddress;

    //Many To One with SportsEvent
    @ManyToOne /*(fetch = FetchType.EAGER, targetEntity = AgencyTypeEntity.class)*/
    @JoinColumn(name = "seid")
    private SportsEvent sportsEvent;

    //Many To One with Province
    @ManyToOne /*(fetch = FetchType.EAGER, targetEntity = ProvinceEntity.class)*/
    @JoinColumn(name = "provinceID")
    private ProvinceEntity provinceEntity;

    //Many To One with SportsType
    @ManyToOne /*(fetch = FetchType.EAGER, targetEntity = ProvinceEntity.class)*/
    @JoinColumn(name = "stid")
    private SportsType sportsType;

    //Many To One with Rating
    @OneToOne /*(fetch = FetchType.EAGER, targetEntity = AgencyTypeEntity.class)*/
    @JoinColumn(name = "rid")
    private RatingEntity ratingEntity;

    //Many To One with PersonType
    @OneToOne /*(fetch = FetchType.EAGER, targetEntity = AgencyTypeEntity.class)*/
    @JoinColumn(name = "personTypeID")
    private PersonTypeEntity personTypeEntity;

    public Long getResultID() {
        return resultID;
    }

    public void setResultID(Long resultID) {
        this.resultID = resultID;
    }

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
    }

    public Date getResultDate() {
        return resultDate;
    }

    public void setResultDate(Date resultDate) {
        this.resultDate = resultDate;
    }

    public String getResultAddress() {
        return resultAddress;
    }

    public void setResultAddress(String resultAddress) {
        this.resultAddress = resultAddress;
    }

    public SportsEvent getSportsEvent() {
        return sportsEvent;
    }

    public void setSportsEvent(SportsEvent sportsEvent) {
        this.sportsEvent = sportsEvent;
    }

    public ProvinceEntity getProvinceEntity() {
        return provinceEntity;
    }

    public void setProvinceEntity(ProvinceEntity provinceEntity) {
        this.provinceEntity = provinceEntity;
    }

    public SportsType getSportsType() {
        return sportsType;
    }

    public void setSportsType(SportsType sportsType) {
        this.sportsType = sportsType;
    }

    public RatingEntity getRatingEntity() {
        return ratingEntity;
    }

    public void setRatingEntity(RatingEntity ratingEntity) {
        this.ratingEntity = ratingEntity;
    }

    public PersonTypeEntity getPersonTypeEntity() {
        return personTypeEntity;
    }

    public void setPersonTypeEntity(PersonTypeEntity personTypeEntity) {
        this.personTypeEntity = personTypeEntity;
    }
}
