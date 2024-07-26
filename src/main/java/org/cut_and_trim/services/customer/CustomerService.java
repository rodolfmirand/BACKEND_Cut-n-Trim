package org.cut_and_trim.services.customer;

import java.util.List;

import org.cut_and_trim.dtos.request.CustomerRequest;
import org.cut_and_trim.dtos.response.CustomerResponse;

public interface CustomerService {

    CustomerResponse register(CustomerRequest customerRequest);
    
    boolean verifyIfPhoneNumberExists(String phoneNumber);

    List<CustomerResponse> findAll();
}
