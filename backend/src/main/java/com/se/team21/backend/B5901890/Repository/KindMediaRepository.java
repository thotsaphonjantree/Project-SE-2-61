package com.se.team21.backend.B5901890.Repository;



import com.se.team21.backend.B5901890.Entity.KindMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestController
@CrossOrigin(origins = "http://localhost:4200")
public interface KindMediaRepository extends JpaRepository<KindMedia,Long> {
    @Query("SELECT t FROM KindMedia t WHERE t.kind_Media = :name")
    KindMedia findByName(@Param("name") String name);
}
