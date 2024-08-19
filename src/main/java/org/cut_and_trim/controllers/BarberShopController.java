package org.cut_and_trim.controllers;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.cut_and_trim.dtos.request.BarberShopRequest;
import org.cut_and_trim.dtos.request.BarberShopRequestAddService;
import org.cut_and_trim.dtos.response.BarberShopResponse;
import org.cut_and_trim.dtos.response.AllBarberShopsResponseServicesList;
import org.cut_and_trim.dtos.response.BarberShopResponseServicesList;
import org.cut_and_trim.dtos.response.ServiceResponse;
import org.cut_and_trim.models.BarberShopImage;
import org.cut_and_trim.services.barberShop.BarberShopService;
import org.cut_and_trim.services.barberShopImage.BarberShopImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(path = "/cutandtrim/barbershop")
public class BarberShopController {

    @Autowired
    private BarberShopService barberShopService;

    @Autowired
    private BarberShopImageService imageService;

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

    @GetMapping("/all-sv-act/{id}")
    public ResponseEntity<BarberShopResponseServicesList> findAllServicesActives(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.ok().body(barberShopService.findAllServicesActives(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarberShopResponseServicesList> findServices(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.ok().body(barberShopService.findServices(id));
    }

    @PostMapping("/upload-image")
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file, @RequestParam("id") UUID id) {
        try {
            BarberShopImage image = imageService.saveImage(file, id);
            return ResponseEntity.ok().body("Image saved with success.");
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Error saving image.");
        }
    }


}
