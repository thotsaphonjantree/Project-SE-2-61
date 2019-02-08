package com.se.team21.backend.B5926329.Sprint2.Entity;

import com.se.team21.backend.B5926329.Entity.Member;
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
@Table(name = "JoinEventMembers")


public class JoinEventMember {
    @Id
    @SequenceGenerator(name = "joineventmember_seq", sequenceName = "joineventmember")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "joineventmember")
    @NotNull private  Long joinEventMemberId;

    @NotNull private String telNum;

    @NotNull private String tagName;

    @NotNull private String personalId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sportId")
    private com.se.team21.backend.b5910311.entity.SportsEvent sportEvent;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "memberId")
    private Member members;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "expertlevelId")
    private ExpertLevel expertLevels;
}
