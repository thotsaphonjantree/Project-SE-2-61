package com.se.team21.backend.B5901890.Repository;


import com.se.team21.backend.B5901890.Entity.KindSportMedia;
import com.se.team21.backend.B5901890.Entity.RegisterMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestController
@CrossOrigin(origins = "http://localhost:4200")
public interface RegisterMediaRepository extends JpaRepository<RegisterMedia,Long> {
    @Query("SELECT t FROM RegisterMedia t WHERE t.name_Media = :name")
    KindSportMedia findBynameRegisterMedia(@Param("name") String name);
}
