package org.cut_and_trim.controllers;

import org.cut_and_trim.dtos.request.CustomerRequest;
import org.cut_and_trim.dtos.response.CustomerResponse;
import org.cut_and_trim.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/cutandtrim/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @PostMapping("/register")
    public ResponseEntity<CustomerResponse> register (@RequestBody CustomerRequest customerRequest){
        return ResponseEntity.ok().body(customerService.register(customerRequest));
    }
}
