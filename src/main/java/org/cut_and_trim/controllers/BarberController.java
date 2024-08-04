package org.cut_and_trim.controllers;

import java.util.List;

import org.cut_and_trim.dtos.request.BarberRegisterRequest;
import org.cut_and_trim.dtos.request.BarberRequest;
import org.cut_and_trim.dtos.request.BarberShopRequest;
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

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody BarberRequest barberRequest) {

        if (barberRequest.getName().isEmpty()
                || barberRequest.getEmail().isEmpty()
                || barberRequest.getPassword().isEmpty())
            return ResponseEntity.badRequest().body("Empty Values.");

        BarberResponse barberResponse = barberService.register(barberRequest);

        if (barberResponse == null)
            return ResponseEntity.internalServerError().body("Barber already exists.");

        return ResponseEntity.ok().body(barberResponse);
    }

    @PostMapping("/register-brshp")
    public ResponseEntity<?> register(@RequestBody BarberRegisterRequest barberRegisterRequest) {

        BarberRequest barberRequest = barberRegisterRequest.getBarber();
        BarberShopRequest barberShopRequest = barberRegisterRequest.getBarberShop();

        if (barberRequest.getName().isEmpty()
                || barberRequest.getEmail().isEmpty()
                || barberRequest.getPassword().isEmpty())
            return ResponseEntity.badRequest().body("Empty Barber Values.");

        if (barberShopRequest.getCep().isEmpty()
                || barberShopRequest.getCity().isEmpty()
                || barberShopRequest.getNeighborhood().isEmpty() || barberShopRequest.getName().isEmpty()
                || barberShopRequest.getStreet().isEmpty() || barberShopRequest.getState().isEmpty())
            return ResponseEntity.badRequest().body("Empty BarberShop Values.");

        BarberResponse barberResponse = barberService.register(barberRequest, barberShopRequest);

        if (barberResponse == null)
            return ResponseEntity.internalServerError().body("Barber already exists.");

        return ResponseEntity.ok().body(barberResponse);

    }

    @GetMapping("/findall")
    public ResponseEntity<List<BarberResponse>> findAll() {
        return ResponseEntity.ok().body(barberService.findAll());
    }
}
