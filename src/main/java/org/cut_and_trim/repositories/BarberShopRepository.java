package org.cut_and_trim.repositories;

import java.util.UUID;

import org.cut_and_trim.models.BarberShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberShopRepository extends JpaRepository<BarberShop, UUID>{
    
}
