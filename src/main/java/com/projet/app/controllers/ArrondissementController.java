package com.projet.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.app.models.Arrondissement;

import com.projet.app.services.ArrondissementService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/arrondissements")
public class ArrondissementController {
	
	@Autowired
	private ArrondissementService as;
	
	@PostMapping
	public Arrondissement addArrondissement(@RequestBody Arrondissement arrondissement) {
		return as.create(arrondissement);
	}
	
	@GetMapping
	public List<Arrondissement> getAllArrondissments(){
		return as.read();
	}
	
	@GetMapping("/{id}")
	public Arrondissement getArrondissementById(@PathVariable("id") Long id){
		return as.read(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteArrondissement(@PathVariable("id") Long id) {
		this.as.deleteArrondissement(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Arrondissement> update(@PathVariable("id") Long id,@RequestBody Arrondissement arrondissement){
		Arrondissement a=as.update(id, arrondissement);
		if(a == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.ok(a);
	}
	
	
}
