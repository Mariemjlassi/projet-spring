package com.projet.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.app.models.Rue;

@Repository
public interface RueRepository extends JpaRepository<Rue, Long>{
	List<Rue> findByZoneId(Long zone_id);
}
