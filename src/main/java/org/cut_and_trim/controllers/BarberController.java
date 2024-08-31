package org.cut_and_trim.controllers;

import java.util.List;

import org.cut_and_trim.dtos.request.BarberRegisterBarberShopRequest;
import org.cut_and_trim.dtos.request.OwnerRegisterBarberShopRequest;
import org.cut_and_trim.dtos.request.BarberRequest;
import org.cut_and_trim.dtos.request.BarberShopRequest;
import org.cut_and_trim.dtos.response.BarberResponse;
import org.cut_and_trim.models.Barber;
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
    public ResponseEntity<?> register(@RequestBody BarberRegisterBarberShopRequest barberRegisterBarberShopRequest){
        BarberResponse barberResponse = barberService.register(barberRegisterBarberShopRequest);

        if(barberResponse == null) return ResponseEntity.badRequest().body("BarberShop not exists or Barber already exists.");

        return ResponseEntity.ok().body(barberResponse);
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<BarberResponse>> findAll() {
        return ResponseEntity.ok().body(barberService.findAll());
    }
}
