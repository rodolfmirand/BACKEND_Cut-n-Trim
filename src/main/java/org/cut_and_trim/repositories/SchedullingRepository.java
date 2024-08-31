package org.cut_and_trim.repositories;

import org.cut_and_trim.models.BarberShop;
import org.cut_and_trim.models.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface SchedullingRepository extends JpaRepository<Scheduling, UUID> {

    @Query("SELECT s FROM Scheduling s WHERE s.barberShop = :barberShop AND s.date = :date ORDER BY s.hourly ASC")
    List<Scheduling> findByBarberShopAndDate(@Param("barberShop") BarberShop barberShop, @Param("date") LocalDate date);

    @Query("SELECT s FROM Scheduling s WHERE s.barberShop = :barberShop AND s.date = :date AND s.hourly = :hourly")
    Scheduling findScheduling(@Param("barberShop") BarberShop barberShop, @Param("date") LocalDate date, @Param("hourly") LocalTime hourly);

}
