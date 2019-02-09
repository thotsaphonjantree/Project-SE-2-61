package com.se.team21.backend.AnanB5911417.sp2.Entity;

import javax.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class EventStore {

    @Id
    @SequenceGenerator(name = "EventStore_seq", sequenceName = "EventStore_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EventStore_seq")


    private @NonNull Long storeId;
    private @NotNull (message="storeName must not be null to be valid")
     String storeName;
    @Size(max = 10, min = 10)
    @Pattern(regexp = "[0-9]*")
    @Column(unique = true)
    private @NotNull String storeTel;
    private @NotNull String octime;

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sportEventForStoreId")
    @NotNull
    private com.se.team21.backend.b5910311.entity.SportsEvent sportEventFStore;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "StaffForStoreId")
    @NotNull
    private com.se.team21.backend.B5901890.Entity.RegisterStaff staffFStore;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TypeforStoreID")
    @NotNull
    private StoreType setTypeStoreFStore;
    
}