package com.se.team21.backend.AnanB5911417.sp2.Entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class EventStore {

    @Id
    @SequenceGenerator(name = "EventStore_seq", sequenceName = "EventStore_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EventStore_seq")


    private @NonNull Long storeId;
    private @NonNull String storeName;
    private @NonNull String storeTel;
    private @NonNull String octime;

    @ManyToOne(fetch = FetchType.EAGER)
     @JoinColumn(name = "sportEventForStoreId")
    private com.se.team21.backend.b5910311.entity.SportsEvent sportEventFStore;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "StaffForStoreId")
    private com.se.team21.backend.B5901890.Entity.RegisterStaff staffFStore;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TypeforStoreID")
    private StoreType setTypeStoreFStore;
    
}