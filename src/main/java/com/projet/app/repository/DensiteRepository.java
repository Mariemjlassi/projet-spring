package com.projet.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.app.models.Densité;

@Repository
public interface DensiteRepository extends JpaRepository<Densité, Long>{

}
