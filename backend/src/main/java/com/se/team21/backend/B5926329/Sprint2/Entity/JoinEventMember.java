package com.se.team21.backend.B5926329.Sprint2.Entity;

import com.se.team21.backend.B5926329.Entity.Member;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "JoinEventMembers",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"memberId", "sportId"})
)


public class JoinEventMember {
    @Id
    @SequenceGenerator(name = "joineventmember_seq", sequenceName = "joineventmember")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "joineventmember")
    @NotNull private  Long joinEventMemberId;

    @NotNull(message="telNum must not be null to be valid")
    @Size(max = 10, min = 10)
    @Pattern(regexp = "[0-9]*")
    private String telNum;

    @NotNull(message="tagName must not be null to be valid")
    private String tagName;

    @Size(max = 13, min = 13)
    @Pattern(regexp = "[0-9]*")
    @Column(unique = true)
    @NotNull(message="personalId must not be null to be valid")
    private String personalId;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sportId")
    @NotNull(message="SportId must not be null to be valid")
    private com.se.team21.backend.b5910311.entity.SportsEvent sportEvent;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "memberId")
    @NotNull(message="memberId must not be null to be valid")
    private Member members;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "expertlevelId")
    @NotNull(message="expertlevelId must not be null to be valid")
    private ExpertLevel expertLevels;

}
