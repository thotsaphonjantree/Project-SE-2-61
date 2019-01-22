package com.se.team21.backend.AnanB5911417.Entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity

public class SportEvent {
    @Id
    @SequenceGenerator(name = "sportsevent_seq", sequenceName = "sportsevent_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sportsevent_seq")

    private @NonNull Long eventId;
    private @NonNull String eventName;
    private @NonNull String sportName;
    private @NonNull String location;

    public SportEvent() {
    }

}