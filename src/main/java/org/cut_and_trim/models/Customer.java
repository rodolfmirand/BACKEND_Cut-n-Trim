package org.cut_and_trim.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @Column(name = "phoneNumber", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private String phoneNumber;

    @Column(name = "name", nullable = true)
    private String name;

    public Customer(String phoneNumber, String name) {
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public Customer(Customer customer) {
        this.phoneNumber = customer.getPhoneNumber();
        this.name = customer.getName();
    }

    public Customer(){
    }
}
