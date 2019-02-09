package com.se.team21.backend.B5926329.Entity;

import com.se.team21.backend.B5926329.Sprint2.Entity.JoinEventMember;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Payments",uniqueConstraints=
@UniqueConstraint(columnNames={"memberId", "JoinEventId"}))
public class Payment {
    @Id
    @SequenceGenerator(name = "payment_seq", sequenceName = "payment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
    @NotNull
    private  Long paymentId;

    @NotNull
    private Long paymentPaid;
    @Temporal(TemporalType.DATE)

    @NotNull
    private Date paymentDate;

    @NotNull
    @Size(min = 1 , max = 25)
    @Pattern(regexp = "[^0-9]*")
    private String nameOnCard;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "payCateId")
    @NotNull
    private PayCategory payCategory;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "JoinEventId")
    @NotNull
    private JoinEventMember joinEventMember;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "memberId")
    @NotNull
    private Member members;

}
