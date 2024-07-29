package org.cut_and_trim.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.cut_and_trim.dtos.request.CustomerRequest;
import org.cut_and_trim.dtos.response.CustomerResponse;
import org.cut_and_trim.models.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toCustomer(CustomerRequest customerRequest) {
        return Customer.builder()
                .phoneNumber(customerRequest.getPhoneNumber())
                .name(customerRequest.getName())
                .build();
    }

    public List<CustomerResponse> toBarbersList(List<Customer> customersList) {
        return customersList.stream().map(CustomerResponse::new).collect(Collectors.toList());
    }
}
