package org.cut_and_trim.repositories;

import java.util.UUID;

import org.cut_and_trim.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, UUID>{
    
}
