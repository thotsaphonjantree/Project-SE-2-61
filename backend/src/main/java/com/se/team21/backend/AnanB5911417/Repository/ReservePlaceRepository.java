package com.se.team21.backend.AnanB5911417.Repository;
import com.se.team21.backend.AnanB5911417.Entity.ReservePlace;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface ReservePlaceRepository extends JpaRepository<ReservePlace,Long> {
}
