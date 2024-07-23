package org.cut_and_trim.controllers;

import org.cut_and_trim.dtos.request.BarberRequest;
import org.cut_and_trim.dtos.response.BarberResponse;
import org.cut_and_trim.services.barber.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cutandtrim/barber")
public class BarberController {
    
    @Autowired
    private BarberService barberService;

    @PostMapping("/register")
    private ResponseEntity<BarberResponse> register(@RequestBody BarberRequest barberRequest){
        return ResponseEntity.ok().body(barberService.register(barberRequest));
    } 
}
