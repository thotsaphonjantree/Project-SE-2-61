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
@Table(name = "Activities")
public class ActivitiesEntity {
    @Id
    @SequenceGenerator(name="activities_seq",sequenceName="activities_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="activities_seq")
    @Column(name="ACTIVITIES_ID",unique = true, nullable = false)

    private @NonNull Long activitiesID;
    private @NonNull String activitiesName;

    public ActivitiesEntity(){}

    public void setActivitiesID(Long activitiesID){
        this.activitiesID = activitiesID;
    }

    public Long getActivitiesID(){
        return this.activitiesID;
    }

    public void setActivitiesName(String activitiesName){
        this.activitiesName = activitiesName;
    }

    public String getActivitiesName(){
        return this.activitiesName;
    }
}
