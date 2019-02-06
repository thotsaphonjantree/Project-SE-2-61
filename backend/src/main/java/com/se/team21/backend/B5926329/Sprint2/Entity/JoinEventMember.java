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
@Table(name = "JoinEvents")


public class JoinEventMember {
    @Id
    @SequenceGenerator(name = "joineventmember_seq", sequenceName = "joineventmember")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "joineventmember")
    @NotNull private  Long joinEventMemberId;

    @NotNull private Long telNum;

    @NotNull private String tagName;

    @NotNull private String name;

    @NotNull private String personalId;

}
