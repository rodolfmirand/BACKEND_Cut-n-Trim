package org.cut_and_trim.services.customer;

import java.util.List;

import org.cut_and_trim.dtos.request.CustomerRequest;
import org.cut_and_trim.dtos.response.CustomerResponse;
import org.cut_and_trim.models.BarberShop;
import org.cut_and_trim.models.Customer;
import org.cut_and_trim.repositories.BarberShopRepository;
import org.cut_and_trim.repositories.CustomerRepository;
import org.cut_and_trim.utils.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImplementation implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BarberShopRepository barberShopRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<CustomerResponse> findAll() {
        return customerMapper.toBarbersList(customerRepository.findAll());
    }

    @Override
    public CustomerResponse register(CustomerRequest customerRequest) {
        Customer customerCheck = customerRepository.findByPhoneNumber(customerRequest.getPhoneNumber()).orElse(null);

        if (customerCheck != null)
            return new CustomerResponse(customerCheck);

        BarberShop barberShop = barberShopRepository.findById(customerRequest.getBarberShopID()).orElse(null);
        Customer customer = customerMapper.toCustomer(customerRequest, barberShop);

        barberShop.addCustomerInList(customer);

        barberShopRepository.save(barberShop);
        customerRepository.save(customer);

        return new CustomerResponse(customer);
    }

    @Override
    public boolean verifyIfPhoneNumberExists(String phoneNumber) {
        return customerRepository.findByPhoneNumber(phoneNumber).isPresent();
    }
}
