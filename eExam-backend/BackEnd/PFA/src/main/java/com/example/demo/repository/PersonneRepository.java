package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Integer>{

	Personne findByCne(String cne);
	Personne findById(int id);

}
