package com.se.team21.backend.B5926329.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Events")
public class Event {
    @Id
    @SequenceGenerator(name = "event_seq", sequenceName = "event_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
    private @NotNull Long eventId;
    private @NotNull String eventName;
    private @NotNull Long eventPrice;
}
