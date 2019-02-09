package com.se.team21.backend.B5926329.Sprint2.Repository;

import com.se.team21.backend.B5926329.Sprint2.Entity.GenderJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GenderJoinRepository extends JpaRepository<GenderJoin, Long> {

}
