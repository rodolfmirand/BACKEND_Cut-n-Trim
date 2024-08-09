package org.cut_and_trim.controllers;

import java.util.UUID;

import org.cut_and_trim.dtos.request.SignupRequest;
import org.cut_and_trim.dtos.response.SignupResponse;
import org.cut_and_trim.services.barber.BarberService;
import org.cut_and_trim.services.owner.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/cutandtrim")
public class LoginController {

    @Autowired
    private BarberService barberService;

    @Autowired
    private OwnerService ownerService;

    @PostMapping("/barber-signup")
    public ResponseEntity<?> signupBarber(@RequestBody SignupRequest signupRequest) {
        if (signupRequest.getEmail().isEmpty() || signupRequest.getPassword().isEmpty())
            return ResponseEntity.badRequest().body("Empty Values.");

        UUID id = barberService.signUp(signupRequest);

        if (id == null)
            return ResponseEntity.badRequest().body("Invalid Signup.");

        return ResponseEntity.ok().body(new SignupResponse(id));
    }

    @PostMapping("/owner-signup")
    public ResponseEntity<?> signupOwner(@RequestBody SignupRequest signupRequest) {
        if (signupRequest.getEmail().isEmpty() || signupRequest.getPassword().isEmpty())
            return ResponseEntity.badRequest().body("Empty values.");

        UUID id = ownerService.signup(signupRequest);

        if (id == null) return ResponseEntity.badRequest().body("Invalid Signup.");

        return ResponseEntity.ok().body(new SignupResponse(id));
    }
}
