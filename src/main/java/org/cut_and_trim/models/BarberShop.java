package org.cut_and_trim.models;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class BarberShop {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "neighborhood", nullable = false)
    private String neighborhood;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "opening_time", nullable = false)
    private String openingTime;

    @Column(name = "closing_time", nullable = false)
    private String closingTime;

    @Column(name = "lunch_time_start", nullable = false)
    private String lunchTimeStart;

    @Column(name = "lunch_time_end", nullable = false)
    private String lunchTimeEnd;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Customer> customers;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Service> services;

    public void addCustomerInList(Customer customer) {
        this.customers.add(customer);
    }

    public void addServiceInList(Service service) {
        this.services.add(service);
    }

    @Builder
    public BarberShop(String name, String street, String number, String neighborhood, String city, String state,
            String cep, String openingTime, String closingTime, String lunchTimeStart, String lunchTimeEnd) {
        this.name = name;
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.cep = cep;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.lunchTimeStart = lunchTimeStart;
        this.lunchTimeEnd = lunchTimeEnd;
    }

    @Builder
    public BarberShop() {
    }
}
