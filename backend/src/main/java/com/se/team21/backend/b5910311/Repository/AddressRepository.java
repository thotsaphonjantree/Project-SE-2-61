package com.se.team21.backend.b5910311.repository;

import com.se.team21.backend.b5910311.entity.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface AddressRepository extends JpaRepository<Address, Long > {
    Address findByAddressname(String addressname);
} 