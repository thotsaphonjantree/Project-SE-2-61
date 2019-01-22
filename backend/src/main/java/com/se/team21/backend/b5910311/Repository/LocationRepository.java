package com.se.team21.backend.b5910311.repository;

import com.se.team21.backend.b5910311.entity.Location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface LocationRepository extends JpaRepository<Location, Long > {
    Location findByLocations(String locations);
} 