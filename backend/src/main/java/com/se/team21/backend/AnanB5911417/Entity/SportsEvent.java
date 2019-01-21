package com.se.team21.backend.Entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity

public class SportsEvent {
    @Id
    @SequenceGenerator(name = "sportsevent_seq", sequenceName = "sportsevent_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sportsevent_seq")

    private @NonNull Long eventId;
    private @NonNull String eventName;
    private @NonNull String sportName;
    private @NonNull String location;

    public SportsEvent() {
    }

}