package com.se.team21.backend.B5909711.Repository;
import com.se.team21.backend.B5909711.Entity.ResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface ResultRepository extends JpaRepository<ResultEntity, Long>{
    ResultEntity findByresultID(Long resultID);

    List<ResultEntity> findBySportsEvent_Eventname(String eventName);
}
