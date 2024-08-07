package org.cut_and_trim.dtos.response;

import org.cut_and_trim.models.Customer;

import lombok.Getter;

@Getter
public class CustomerResponse {
    
    private String phoneNumber;

    private String name;

    public CustomerResponse(Customer customer){
        this.phoneNumber = customer.getPhoneNumber();
        this.name = customer.getName();
    }
}
