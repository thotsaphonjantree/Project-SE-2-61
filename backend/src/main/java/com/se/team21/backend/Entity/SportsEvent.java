package th.sut.sa.demo.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SportsEvent")
public class SportsEvent {
    @Id
    @SequenceGenerator(name = "sportsevent_seq", sequenceName = "sportsevent_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sportsevent_seq")
    @Column(name="SportsEvent_ID",unique = true, nullable = true)
    private @NonNull Long id;
    private @NonNull String sport;
    private @NonNull String location;

    public SportsEvent() {
    }

    public SportsEvent(Long id,String sport,String location) {
        this.id = id;
        this.sport = sport;
        this.location = location;
    }
    public String getSport() {
        return sport;
       }
       public void setSport(String sport) {
        this.sport = sport;
       }
       public String getLocation() {
        return location;
       }
       public void setLocation(String location) {
        this.location = location;
       }
       public void setId(Long id) {
        this.id = id;
       }
       public Long getId() {
        return id;
       }
       

}