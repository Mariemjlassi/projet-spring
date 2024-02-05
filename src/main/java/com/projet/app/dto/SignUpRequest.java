package com.projet.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignUpRequest {
	
	private String email;
	private String password;
	private String name;
}
