package com.se.team21.backend.B5926329.Entity;

import com.se.team21.backend.B5926329.Sprint2.Entity.JoinEventMember;
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
    @JoinColumn(name = "JoinEventId")
    private JoinEventMember joinEventMember;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "memberId")
    private Member members;

}
