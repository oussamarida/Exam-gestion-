package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Matiere;

public interface MatiereRepository extends JpaRepository<Matiere, Integer> {

	Matiere findByNom(String nom);

	boolean existsByNom(String matiere);
 
}
