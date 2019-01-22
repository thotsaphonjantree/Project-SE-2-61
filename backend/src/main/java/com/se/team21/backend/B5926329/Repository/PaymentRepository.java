package com.se.team21.backend.B5926329.Repository;

import com.se.team21.backend.B5926329.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PaymentRepository extends JpaRepository<Payment, Long>{
}
