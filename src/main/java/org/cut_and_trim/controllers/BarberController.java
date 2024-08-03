package org.cut_and_trim.controllers;

import java.util.List;

import org.cut_and_trim.dtos.request.BarberRegisterRequest;
import org.cut_and_trim.dtos.response.BarberResponse;
import org.cut_and_trim.services.barber.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cutandtrim/barber")
public class BarberController {

    @Autowired
    private BarberService barberService;

    // @PostMapping("/register")
    // public ResponseEntity<BarberResponse> register(@RequestBody BarberRequest
    // barberRequest){
    // return ResponseEntity.ok().body(barberService.register(barberRequest));
    // }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody BarberRegisterRequest barberRegisterRequest) {

        if (barberRegisterRequest.getBarber().getName().isEmpty()
                || barberRegisterRequest.getBarber().getEmail().isEmpty()
                || barberRegisterRequest.getBarber().getPassword().isEmpty()
                || barberRegisterRequest.getBarber().getUsername().isEmpty())
            return ResponseEntity.badRequest().body("Empty Values.");

        BarberResponse barberResponse =  barberService.register(barberRegisterRequest);

        if(barberResponse == null) return ResponseEntity.internalServerError().body("Barber already exists.");

        return ResponseEntity.ok().body(barberResponse);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<BarberResponse>> findAll() {
        return ResponseEntity.ok().body(barberService.findAll());
    }
}
