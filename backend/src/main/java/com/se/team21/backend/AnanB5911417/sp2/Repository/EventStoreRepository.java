package com.se.team21.backend.AnanB5911417.sp2.Repository;
import com.se.team21.backend.AnanB5911417.sp2.Entity.EventStore;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface EventStoreRepository extends JpaRepository<EventStore,Long> {
}
