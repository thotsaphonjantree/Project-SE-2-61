package com.se.team21.backend.B5909711.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.se.team21.backend.B5909711.Entity.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface RatingRepository extends JpaRepository<RatingEntity, Long>{
    RatingEntity findByratingName(String ratingName);
}
