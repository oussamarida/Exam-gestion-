package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Semestre;

public interface SemestreRepository extends JpaRepository<Semestre, Integer> {


    Semestre findByNom(String nom);  


}
