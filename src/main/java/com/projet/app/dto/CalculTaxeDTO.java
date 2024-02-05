package com.projet.app.dto;

import lombok.Data;

@Data
public class CalculTaxeDTO {
	
	private Double surface;
    private String methodeCalcul;
    private Double valeurVenale;
    private Long densiteId;

}
