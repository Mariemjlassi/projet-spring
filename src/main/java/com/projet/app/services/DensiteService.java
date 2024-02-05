package com.projet.app.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.app.models.Densité;
import com.projet.app.repository.DensiteRepository;

@Service
public class DensiteService {
	@Autowired
	private DensiteRepository dr;
	
	public Densité create(Densité densité) {
		return dr.save(densité);
	}
	
	public List<Densité> read(){
		return dr.findAll();
	}
	
	public Densité findById(Long id) {
		return dr.findById(id).orElse(null);
	}

}
