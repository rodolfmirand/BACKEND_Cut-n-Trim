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

    @OneToMany(cascade = CascadeType.ALL)
    private List<Customer> customers;

    public void addCustomerInList(Customer customer){
        this.customers.add(customer);
    }

    @Builder
    public BarberShop(String name, String street, String number, String neighborhood, String city, String state,
            String cep) {
        this.name = name;
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.cep = cep;
    }

    @Builder
    public BarberShop(){
        
    }
}
