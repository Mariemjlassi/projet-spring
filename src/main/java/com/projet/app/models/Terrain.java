package com.projet.app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name="terrain")
@AllArgsConstructor
@NoArgsConstructor
public class Terrain {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double surface;
	private String adresse;
	
	
	@ManyToOne
	@JoinColumn(name="rue_id")
	private Rue rue;
	
	@ManyToOne
	@JoinColumn(name="proprietaire_id")
	private Proprietaire proprietaire;
	
	
	public Terrain(Double surface, String adresse) {
		super();
		this.surface = surface;
		this.adresse = adresse;
	}
	

}
