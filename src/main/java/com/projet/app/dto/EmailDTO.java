package com.projet.app.dto;

import lombok.Data;

@Data
public class EmailDTO {
	String to;
	String cc;
	String subject;
	String body;

}
