package org.cut_and_trim.models;

import java.util.List;
import java.util.UUID;

import org.cut_and_trim.dtos.request.BarberShopRequest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "barber_shops")
public class BarberShop {

    @Id
    @Column(name = "id", nullable = false, unique = true)
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
    private int openingTime;

    @Column(name = "closing_time", nullable = false)
    private int closingTime;

    @Column(name = "lunch_time_start", nullable = false)
    private int lunchTimeStart;

    @Column(name = "lunch_time_end", nullable = false)
    private int lunchTimeEnd;

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

    public void removeServiceFromList(Service service){
        for(Service sv : this.services){
            if(sv.getId().equals(service.getId())){
                this.services.remove(sv);
                break;
            } 
        }
    }

    public BarberShop(String name, String street, String number, String neighborhood, String city, String state,
            String cep, int openingTime, int closingTime, int lunchTimeStart, int lunchTimeEnd) {
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

    public BarberShop() {
    }

    public BarberShop(BarberShopRequest barberShopRequest) {
        this.name = barberShopRequest.getName();
        this.street = barberShopRequest.getStreet();
        this.number = barberShopRequest.getNumber();
        this.neighborhood = barberShopRequest.getNeighborhood();
        this.city = barberShopRequest.getCity();
        this.state = barberShopRequest.getState();
        this.cep = barberShopRequest.getCep();
        this.openingTime = barberShopRequest.getOpeningTime();
        this.closingTime = barberShopRequest.getClosingTime();
        this.lunchTimeStart = barberShopRequest.getLunchTimeStart();
        this.lunchTimeEnd = barberShopRequest.getLunchTimeEnd();
    }
}
