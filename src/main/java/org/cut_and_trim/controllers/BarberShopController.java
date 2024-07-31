package org.cut_and_trim.controllers;

import java.util.List;

import org.cut_and_trim.dtos.request.BarberShopRequest;
import org.cut_and_trim.dtos.request.BarberShopRequestAddService;
import org.cut_and_trim.dtos.response.BarberShopResponse;
import org.cut_and_trim.dtos.response.BarberShopResponseServiceList;
import org.cut_and_trim.dtos.response.ServiceResponse;
import org.cut_and_trim.services.barberShop.BarberShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/cutandtrim/barbershop")
public class BarberShopController {
    
    @Autowired
    private BarberShopService barberShopService;

    @PostMapping("/register")
    public ResponseEntity<BarberShopResponse> register(@RequestBody BarberShopRequest barberShopRequest){
        return ResponseEntity.ok().body(barberShopService.register(barberShopRequest));
    }

    @PostMapping("/add-service")
    public ResponseEntity<ServiceResponse> addService(@RequestBody BarberShopRequestAddService barberShopRequestAddService){
        return ResponseEntity.ok().body(barberShopService.addServiceInList(barberShopRequestAddService.getBarberShopID(), barberShopRequestAddService.getService()));
    }

    @GetMapping("/all-services")
    public ResponseEntity<List<BarberShopResponseServiceList>> findAllServices(){
        return ResponseEntity.ok().body(barberShopService.findAllServices());
    }
}
