package org.cut_and_trim.controllers;

import org.cut_and_trim.dtos.request.BarberShopRequest;
import org.cut_and_trim.dtos.request.OwnerRegisterBarberShopRequest;
import org.cut_and_trim.dtos.request.OwnerRequest;
import org.cut_and_trim.dtos.response.OwnerResponse;
import org.cut_and_trim.services.owner.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cutandtrim/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody OwnerRegisterBarberShopRequest request) {
        OwnerRequest ownerRequest = request.getOwner();
        BarberShopRequest barberShopRequest = request.getBarberShop();

        if (ownerRequest.getName().isEmpty() || ownerRequest.getEmail().isEmpty() || ownerRequest.getPassword().isEmpty())


        if (barberShopRequest.getCep().isEmpty()
                || barberShopRequest.getCity().isEmpty()
                || barberShopRequest.getNeighborhood().isEmpty() || barberShopRequest.getName().isEmpty()
                || barberShopRequest.getStreet().isEmpty() || barberShopRequest.getState().isEmpty())
            return ResponseEntity.badRequest().body("Empty BarberShop Values.");

        OwnerResponse ownerResponse = ownerService.register(ownerRequest, barberShopRequest);

        if (ownerResponse == null) return ResponseEntity.badRequest().body("Owner already exists.");

        return ResponseEntity.ok().body(ownerResponse);
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<OwnerResponse>> findAll(){
        return ResponseEntity.ok().body(ownerService.findAll());
    }
}
