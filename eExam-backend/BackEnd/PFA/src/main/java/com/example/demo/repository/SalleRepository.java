package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Salle;
import com.example.demo.entities.Surveillant;

public interface SalleRepository extends JpaRepository<Salle, Integer> {

	Salle findByCode(String code);

	List<Salle> findBySurveillant(Surveillant surveillant);

	@Query("SELECT s FROM Salle s WHERE s.surveillant.id = :surveillantId")
	List<Salle> findBySurveillantId(@Param("surveillantId") Long surveillantId);

	List<Salle> findByTablesEtudiantId(Long etudiantId);

}
