package org.cut_and_trim.repositories;

import org.cut_and_trim.models.Barber;
import org.cut_and_trim.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, UUID> {
    Optional<Owner> findByEmail(String email);

}
