package com.se.team21.backend.B5926329.Entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name = "Members")
public class Member {
    @Id
    @SequenceGenerator(name = "member_seq", sequenceName = "member_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq")
    private @NonNull Long memberId;
    private @NonNull String username;
    private @NonNull String password;
    private @NonNull String name;

}
