package com.se.team21.backend.B5909711.Repository;

import com.se.team21.backend.B5909711.Entity.ActivitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface ActivitiesRepository extends JpaRepository<ActivitiesEntity, Long>{
    ActivitiesEntity findByactivitiesName(String activitiesName);
}
