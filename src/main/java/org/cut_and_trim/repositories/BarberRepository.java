package org.cut_and_trim.repositories;

import java.util.Optional;
import java.util.UUID;

import org.cut_and_trim.models.Barber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberRepository extends JpaRepository<Barber, UUID>{
    Optional<Barber> findByPhoneNumber(String phoneNumber);
    Optional<Barber> findByEmail(String email);
}
