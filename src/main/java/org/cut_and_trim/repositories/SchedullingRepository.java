package org.cut_and_trim.repositories;

import org.cut_and_trim.models.Barber;
import org.cut_and_trim.models.BarberShop;
import org.cut_and_trim.models.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SchedullingRepository extends JpaRepository<Scheduling, UUID> {

    Optional<List<Scheduling>> findByBarberAndDate(BarberShop barberShop, LocalDate date);

    Optional<Scheduling> findScheduling(BarberShop barberShop, LocalDate date, LocalTime hourly);
}
