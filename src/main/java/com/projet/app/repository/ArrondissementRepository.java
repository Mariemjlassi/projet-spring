package com.projet.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.app.models.Arrondissement;

@Repository
public interface ArrondissementRepository extends JpaRepository<Arrondissement, Long> {

}
