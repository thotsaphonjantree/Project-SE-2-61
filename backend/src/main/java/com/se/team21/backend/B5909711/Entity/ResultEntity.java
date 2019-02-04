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
    private @NonNull String resultRating;

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

}
