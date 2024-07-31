package org.cut_and_trim.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
@Builder
public class Customer {

    @Id
    @Column(name = "phoneNumber", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "name", nullable = true)
    private String name;

    @Builder
    public Customer(String phoneNumber, String name) {
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    @Builder
    public Customer(Customer customer) {
        this.phoneNumber = customer.getPhoneNumber();
        this.name = customer.getName();
    }

    @Builder
    public Customer(){
    }
}
