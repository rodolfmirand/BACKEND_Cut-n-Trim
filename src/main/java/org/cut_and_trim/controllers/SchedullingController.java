package org.cut_and_trim.controllers;

import org.cut_and_trim.dtos.request.SchedulingCreateRequest;
import org.cut_and_trim.dtos.request.SchedullingDeleteRequest;
import org.cut_and_trim.dtos.request.SchedullingRequest;
import org.cut_and_trim.dtos.request.ServiceDeleteRequest;
import org.cut_and_trim.models.Scheduling;
import org.cut_and_trim.services.scheduling.SchedulingServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/cutandtrim/scheduling")
public class SchedullingController {

    @Autowired
    private SchedulingServiceImplementation service;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SchedulingCreateRequest request){
        if(request.getBarberShopId() == null
            || request.getCustomerPhone().isEmpty()
            || request.getServiceId() == null
            || request.getHourly() == null
            || request.getDate() == null
        ){
            return ResponseEntity.badRequest().body("Empty scheduling values.");
        }


        Boolean response = service.createSchedulling(request);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/findDay")
    public ResponseEntity<List<Scheduling>> getScheduling(
        @RequestParam("BarberShopId") UUID barberId,
        @RequestParam("Date") LocalDate date
    ){
        SchedullingRequest request = new SchedullingRequest(barberId,date);

        List<Scheduling> response = service.getSchedulling(request);

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody SchedullingDeleteRequest request){
        if(!service.deleteSchedulling(request)) return ResponseEntity.badRequest().body("Scheduling not founded.");
        return ResponseEntity.ok().body("Scheduling deleted successfully.");
    }
}
