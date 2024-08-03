package org.cut_and_trim.controllers;

import java.util.UUID;

import org.cut_and_trim.dtos.request.SignupRequest;
import org.cut_and_trim.dtos.response.SignupResponse;
import org.cut_and_trim.services.barber.BarberService;
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

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
        if (signupRequest.getEmail().isEmpty() || signupRequest.getPassword().isEmpty())
            return ResponseEntity.badRequest().body("Empty Values.");

        UUID id = barberService.signUp(signupRequest);

        if (id == null)
            return ResponseEntity.badRequest().body("Invalid signup.");

        return ResponseEntity.ok().body(new SignupResponse(id));
    }
}
