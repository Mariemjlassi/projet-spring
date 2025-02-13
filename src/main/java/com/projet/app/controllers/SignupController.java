package com.projet.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.app.dto.SignUpRequest;
import com.projet.app.models.DBUser;
import com.projet.app.services.AuthService;

@RestController
@RequestMapping("/signup")
public class SignupController {
	
	private final AuthService authService;
	
	@Autowired
	public SignupController(AuthService authService) {
		this.authService=authService;
	}
	
	@PostMapping
	public ResponseEntity<?> signupUser(@RequestBody SignUpRequest signupRequest ){
		DBUser createdUser = authService.createUser(signupRequest);
        if (createdUser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create user");
        }
    }
	
}
