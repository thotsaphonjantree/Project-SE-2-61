package com.se.team21.backend.B5926329.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Payments")
public class Payment {
    @Id
    @SequenceGenerator(name = "payment_seq", sequenceName = "payment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
    private @NonNull Long paymentId;
    private @NonNull Long paymentPaid;
    @Temporal(TemporalType.DATE)
    private @NonNull Date paymentDate;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "payCateId")
    private PayCategory payCategory;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sportId")
    private com.se.team21.backend.b5910311.entity.SportsEvent sportEvent;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "memberId")
    private Member members;

}
