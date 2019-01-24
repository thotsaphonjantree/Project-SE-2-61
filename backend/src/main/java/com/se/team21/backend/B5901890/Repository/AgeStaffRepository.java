package com.se.team21.backend.B5901890.Repository;



import com.se.team21.backend.B5901890.Entity.AgeStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestController
@CrossOrigin(origins = "http://localhost:4200")
public interface AgeStaffRepository extends JpaRepository<AgeStaff,Long> {

    @Query("SELECT t FROM AgeStaff t WHERE t.age = :name")
    AgeStaff findBynameAge(@Param("name") Integer name);
}
