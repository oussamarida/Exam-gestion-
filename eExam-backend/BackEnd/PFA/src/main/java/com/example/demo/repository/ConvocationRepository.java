package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Convocation;
import com.example.demo.entities.Etudiant;

public interface ConvocationRepository extends JpaRepository<Convocation, Integer> {

	Convocation findById(int id);

	Convocation findByEtudiantId(int etudiantId);

}
