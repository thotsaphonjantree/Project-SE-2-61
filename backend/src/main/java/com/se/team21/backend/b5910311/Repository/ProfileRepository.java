package com.se.team21.backend.b5910311.repository;

import com.se.team21.backend.b5910311.entity.Profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface ProfileRepository extends JpaRepository<Profile, Long > {
    Profile findByPid(Long pid);
} 