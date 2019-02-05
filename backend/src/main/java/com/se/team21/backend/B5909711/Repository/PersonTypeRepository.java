package com.se.team21.backend.B5909711.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.jpa.repository.JpaRepository;
import com.se.team21.backend.B5909711.Entity.PersonTypeEntity;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface PersonTypeRepository extends JpaRepository<PersonTypeEntity, Long>{
    PersonTypeEntity findBypersonTypeName(String personTypeName);
}
