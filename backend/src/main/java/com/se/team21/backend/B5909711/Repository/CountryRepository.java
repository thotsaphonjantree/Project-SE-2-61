package com.se.team21.backend.B5909711.Repository;

import com.se.team21.backend.B5909711.Entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface CountryRepository extends JpaRepository<CountryEntity, Long>{
    CountryEntity findBycountryName(String countryName);
}
