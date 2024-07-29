package org.cut_and_trim.controllers;

import org.cut_and_trim.dtos.request.BarberShopRequest;
import org.cut_and_trim.dtos.response.BarberShopResponse;
import org.cut_and_trim.services.barberShop.BarberShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
}
