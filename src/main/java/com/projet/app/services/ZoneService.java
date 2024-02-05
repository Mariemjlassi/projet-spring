package com.projet.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.app.models.Zone;
import com.projet.app.repository.ZoneRepository;

@Service
public class ZoneService {
	
	
	@Autowired
	private ZoneRepository zr;
	
	public Zone create(Zone zone) {
		
		return zr.save(zone);
	}
	
	public List<Zone> read(){
		
		return zr.findAll();
	}
	
	public  Zone read(Long id) {
		Optional<Zone> zone = zr.findById(id);
		if(zone.isPresent()) {
			return zone.get();
		}else {
			return null;
		}
	}
	
	public void deleteZone(Long id) {
		zr.deleteById(id);
	}
	
	public Zone update(Long id, Zone zone) {
		Optional<Zone> z= zr.findById(id);
		if(z.isPresent()) {
			Zone existingZone=z.get();
			existingZone.setNom(zone.getNom());
			return zr.save(existingZone);
		}
		return null;
	}
	
	
	public List<Zone> getZoneByArrondissement(Long arrondissement_id){
		return zr.findByArrondissementId(arrondissement_id);
	}
	
	
}
