package com.se.team21.backend.B5926329.Entity;

import lombok.*;

import javax.persistence.*;

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
    private @NonNull Long eventId;
    private @NonNull String eventName;
    private @NonNull Long eventPrice;
}
