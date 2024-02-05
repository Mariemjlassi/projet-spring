package com.projet.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.app.models.Terrain;

import com.projet.app.services.TerrainService;

@RestController
@RequestMapping("/terrain")
public class TerrainController {
	
	@Autowired
	private TerrainService terrainService;
	
	@PostMapping
	public Terrain addTerrain(@RequestBody Terrain terrain) {
		return terrainService.create(terrain);
	}
	
	@GetMapping
	public List<Terrain> getAllTerrain(){
		return terrainService.read();
	}
	
	@GetMapping("/{id}")
	public Terrain getTerrainById(@PathVariable ("id") Long id) {
		return terrainService.read(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		terrainService.deleteTerrain(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Terrain> update(@PathVariable("id") Long id,@RequestBody Terrain terrain){
		Terrain terrain2=terrainService.update(id, terrain);
		if(terrain2 == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.ok(terrain2);
	}

}
