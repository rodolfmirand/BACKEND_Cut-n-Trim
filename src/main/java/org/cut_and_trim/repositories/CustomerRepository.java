package org.cut_and_trim.repositories;

import java.util.Optional;
import java.util.UUID;

import org.cut_and_trim.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    
    Optional<Customer> findByPhoneNumber(String phoneNumber);
}
