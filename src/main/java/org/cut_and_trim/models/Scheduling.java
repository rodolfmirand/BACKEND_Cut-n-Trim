package org.cut_and_trim.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "scheduling")
public class Scheduling {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "barber_shop_id", nullable = false)
    private BarberShop barberShoper;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @Column(name = "start_hourly", nullable = false)
    private LocalTime hourly;

    @Column(name = "date", nullable = false)
    private LocalDate date;


    public Scheduling(BarberShop barberShoper, Customer customer, Service service, LocalTime hourly, LocalDate date) {
        this.barberShoper = barberShoper;
        this.customer = customer;
        this.service = service;
        this.hourly = hourly;
        this.date = date;
    }
}
