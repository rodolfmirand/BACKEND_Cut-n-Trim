package org.cut_and_trim.controllers;

import org.cut_and_trim.dtos.request.ServiceRequest;
import org.cut_and_trim.dtos.response.ServiceResponse;
import org.cut_and_trim.services.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/cutandtrim/service")
public class ServiceController {
    
    @Autowired
    private ServiceService service;

    @PostMapping("/register")
    public ResponseEntity<ServiceResponse> register(@RequestBody ServiceRequest serviceRequest){
        return ResponseEntity.ok().body(service.register(serviceRequest));
    }
}
