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
@Table(name = "SportEvents")
public class SportEvent {
    @Id
    @SequenceGenerator(name = "sportEvent_seq", sequenceName = "sportEvent_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sportEvent_seq")
    private @NonNull Long sportId;
    private @NonNull String sportName;
    private @NonNull Long sportPrice;
}
