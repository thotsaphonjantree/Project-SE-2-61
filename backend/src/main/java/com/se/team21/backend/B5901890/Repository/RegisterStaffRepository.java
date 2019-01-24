package com.se.team21.backend.B5901890.Repository;


import com.se.team21.backend.B5901890.Entity.AgeStaff;
import com.se.team21.backend.B5901890.Entity.RegisterStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestController
@CrossOrigin(origins = "http://localhost:4200")
public interface RegisterStaffRepository extends JpaRepository<RegisterStaff,Long> {
    @Query("SELECT t FROM RegisterStaff t WHERE t.nameRegisterStaff = :name")
    AgeStaff findBynameRegisterStaff(@Param("name") String name);
}
