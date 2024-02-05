package com.projet.app.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.app.dto.LoginRequest;
import com.projet.app.dto.LoginResponse;
import com.projet.app.services.jwt.DBUserServiceImpl;
import com.projet.app.utils.JwtUtil;

import jakarta.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/login")
public class LoginController {
	
	private final AuthenticationManager authenticationManager;
	private final DBUserServiceImpl dbUserServiceImpl;
	private final JwtUtil jwtUtil;
	
	
	@Autowired
	public LoginController(AuthenticationManager authenticationManager, DBUserServiceImpl dbUserServiceImpl,JwtUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.dbUserServiceImpl = dbUserServiceImpl;
		this.jwtUtil = jwtUtil;
	}
	
	
	 	@PostMapping
	 	public LoginResponse login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) throws IOException {
	        try {
	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
	        } catch (BadCredentialsException e) {
	            throw new BadCredentialsException("Incorrect email or password.");
	        } catch (DisabledException disabledException) {
	            response.sendError(HttpServletResponse.SC_NOT_FOUND, "User is not activated");
	            return null;
	        }
	        final UserDetails userDetails = dbUserServiceImpl.loadUserByUsername(loginRequest.getEmail());
	        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

	        return new LoginResponse(jwt);
	    }
}
