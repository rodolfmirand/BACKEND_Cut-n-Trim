package org.cut_and_trim.controllers;

import org.cut_and_trim.dtos.request.ServiceDeleteRequest;
import org.cut_and_trim.dtos.request.ServiceRequest;
import org.cut_and_trim.dtos.request.ServiceUpdateRequest;
import org.cut_and_trim.dtos.response.ServiceResponse;
import org.cut_and_trim.services.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping(path = "/cutandtrim/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping("/register")
    public ResponseEntity<ServiceResponse> register(@RequestBody ServiceRequest serviceRequest) {
        return ResponseEntity.ok().body(serviceService.register(serviceRequest));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ServiceUpdateRequest serviceUpdateRequest) {
        ServiceResponse serviceResponse = serviceService.update(serviceUpdateRequest);

        if (serviceResponse == null) return ResponseEntity.badRequest().body("Service not founded.");

        return ResponseEntity.ok().body(serviceResponse);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody ServiceDeleteRequest serviceDeleteRequest) {
        if (!serviceService.delete(serviceDeleteRequest))
            return ResponseEntity.badRequest().body("Service not founded.");
        return ResponseEntity.ok().body("Service deleted successfully.");
    }

    @GetMapping("/find")
    public ResponseEntity<?> findById(@RequestParam("id") UUID id) {
        ServiceResponse serviceResponse = serviceService.findById(id);
        if (serviceResponse != null)
            return ResponseEntity.ok().body(serviceResponse);
        return ResponseEntity.badRequest().body("Service not exists.");
    }
}
