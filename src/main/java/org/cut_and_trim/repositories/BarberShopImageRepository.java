package org.cut_and_trim.repositories;

import org.cut_and_trim.models.BarberShopImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BarberShopImageRepository extends JpaRepository<BarberShopImage, UUID> {
}
