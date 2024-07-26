package org.cut_and_trim.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class Customer {

    @Id
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @Column(name = "name", nullable = true)
    private String name;

    @ManyToOne
    private BarberShop barberShop;

    @Builder
    public Customer(String phoneNumber, String name, BarberShop barberShop){
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.barberShop = barberShop;
    }

    @Builder
    public Customer(Customer customer) {
        this.phoneNumber = customer.getPhoneNumber();
        this.name = customer.getName();
        this.barberShop = customer.getBarberShop();
    }

    @Builder
    public Customer(){
    }
}
