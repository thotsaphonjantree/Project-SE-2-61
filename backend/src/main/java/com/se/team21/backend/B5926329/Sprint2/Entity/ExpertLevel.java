package com.se.team21.backend.B5926329.Sprint2.Entity;

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
@Table(name = "ExpertLevel")

public class ExpertLevel {
    @Id
    @SequenceGenerator(name = "expertlevel_seq", sequenceName = "expertlevel_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expertlevel_seq")
    private @NotNull Long expertLevelId;
    private @NotNull String expertLevelName;
}
