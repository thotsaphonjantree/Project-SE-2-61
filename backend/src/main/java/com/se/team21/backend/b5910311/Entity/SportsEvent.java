package com.se.team21.backend.b5910311.entity;

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
    private @NonNull Long seid;
    private @NonNull String eventname;

    public SportsEvent() {
    }

    public SportsEvent(Long seid,String eventname) {
        this.seid = seid;
        this.eventname = eventname;
    }
    public String getEventName() {
        return eventname;
       }
       public void setEventName(String eventname) {
        this.eventname = eventname;
       }
       public void setSEid(Long seid) {
        this.seid = seid;
       }
       public Long getSEid() {
        return seid;
       }
       

}