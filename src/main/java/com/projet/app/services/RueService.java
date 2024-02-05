package com.projet.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.app.models.Rue;
import com.projet.app.repository.RueRepository;

@Service
public class RueService {
	
	@Autowired
	private RueRepository rRep;
	
	public Rue create(Rue rue) {
		
		return rRep.save(rue);
	}
	
	public List<Rue> read(){
		return rRep.findAll();
	}
	
	public Rue readById(Long id) {
		Optional<Rue> rue = rRep.findById(id);
		if(rue.isPresent()) {
			return rue.get();
		}else {
			return null;
		}
	}
	public void delete(Long id) {
		rRep.deleteById(id);
	}
	
	public Rue update(Long id,Rue rue) {
		Optional<Rue> r= rRep.findById(id);
		if(r.isPresent()) {
			Rue existingRue = r.get();
			existingRue.setNom(rue.getNom());
			return rRep.save(existingRue);
		}
		return null;
	}
	
	public List<Rue> getRueByZone(Long zone_id){
		return rRep.findByZoneId(zone_id);
	}

}
