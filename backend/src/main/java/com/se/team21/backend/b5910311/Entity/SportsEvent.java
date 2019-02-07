package com.se.team21.backend.b5910311.entity;

import java.util.List;
import lombok.Data;
import lombok.NonNull;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
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
    private @NonNull Long price;
    private @NonNull String eventname;
    private @NonNull String eventdetail;

    public SportsEvent() {
    }

    public SportsEvent(Long seid,Long price,String eventname,String eventdetail) {
        this.seid = seid;
        this.price = price;
        this.eventname = eventname;
        this.eventname = eventdetail;
    }
    public String getEventName() {
        return eventname;
    }
    public void setEventName(String eventname) {
        this.eventname = eventname;
    }
    public String getEventDetail() {
        return eventdetail;
    }
    public void setEventDetail(String eventdetail) {
        this.eventdetail = eventdetail;
    }
    public void setSEid(Long seid) {
        this.seid = seid;
    }
    public Long getSEid() {
        return seid;
    }
    public void setPrice(Long price) {
        this.price = price;
    }
    public Long getPrice() {
        return price;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SE_LO")
    private Location locations;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SE_SES")
    private SportsEventStaff sesname;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SE_ST")
    private SportsType sportsType;
    
}