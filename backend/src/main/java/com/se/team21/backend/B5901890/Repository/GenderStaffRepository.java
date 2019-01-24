package com.se.team21.backend.B5901890.Repository;



import com.se.team21.backend.B5901890.Entity.GenderStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestController
@CrossOrigin(origins = "http://localhost:4200")
public interface GenderStaffRepository extends JpaRepository<GenderStaff,Long> {
    @Query("SELECT t FROM GenderStaff t WHERE t.nameGender = :name")
    GenderStaff findBynameGender(@Param("name") String name);
}
