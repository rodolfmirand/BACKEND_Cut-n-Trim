package org.cut_and_trim.controllers;

import java.util.List;
import java.util.UUID;

import org.cut_and_trim.dtos.request.BarberShopRequest;
import org.cut_and_trim.dtos.request.BarberShopRequestAddService;
import org.cut_and_trim.dtos.response.BarberShopResponse;
import org.cut_and_trim.dtos.response.AllBarberShopsResponseServicesList;
import org.cut_and_trim.dtos.response.BarberShopResponseServicesList;
import org.cut_and_trim.dtos.response.ServiceResponse;
import org.cut_and_trim.services.barberShop.BarberShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/cutandtrim/barbershop")
public class BarberShopController {

    @Autowired
    private BarberShopService barberShopService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody BarberShopRequest barberShopRequest) {
        if (barberShopRequest.getBarberID() == null || barberShopRequest.getCep().isEmpty()
                || barberShopRequest.getCity().isEmpty()
                || barberShopRequest.getNeighborhood().isEmpty() || barberShopRequest.getName().isEmpty()
                || barberShopRequest.getStreet().isEmpty() || barberShopRequest.getState().isEmpty())
            return ResponseEntity.badRequest().body("Empty Values.");

        BarberShopResponse barberShopResponse = barberShopService.register(barberShopRequest);

        if (barberShopResponse == null)
            return ResponseEntity.internalServerError().body("BarberShop already exists.");

        return ResponseEntity.ok().body(barberShopResponse);
    }

    @PostMapping("/add-service")
    public ResponseEntity<ServiceResponse> addService(
            @RequestBody BarberShopRequestAddService barberShopRequestAddService) {
        return ResponseEntity.ok().body(barberShopService.addServiceInList(
                barberShopRequestAddService.getBarberShopID(), barberShopRequestAddService.getService()));
    }

    @GetMapping("/all-bs-sv")
    public ResponseEntity<List<AllBarberShopsResponseServicesList>> findAllServices() {
        return ResponseEntity.ok().body(barberShopService.findAllServices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarberShopResponseServicesList> findServices(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.ok().body(barberShopService.findServices(id));
    }
}
