package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Admin;
import com.example.demo.entities.Professeur;

public interface ProfesseurRepository extends JpaRepository<Professeur, Integer>{

	Professeur findByEmail(String email);

}
