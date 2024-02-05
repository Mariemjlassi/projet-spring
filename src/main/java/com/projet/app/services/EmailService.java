package com.projet.app.services;

public interface EmailService {
	String sendEmail(String to,String cc,String subject,String body);
}
