package com.projet.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProprietaireEtTerrainDTO {
	private String nom;
    private String prenom;
    private String cin;
    private String adresse;
    private Double surface;
    private String email;
	public ProprietaireEtTerrainDTO(String nom, String prenom, String cin, String adresse, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.adresse = adresse;
		this.email=email;
	}
	public ProprietaireEtTerrainDTO(String adresse, Double surface) {
		super();
		this.adresse = adresse;
		this.surface = surface;
	}
}
