package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Admin;
import com.example.demo.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

	@Query("SELECT e FROM Etudiant e WHERE e.napo = :napo")
	Etudiant findByNApo(@Param("napo") Long napo);

    @Query("SELECT e FROM Etudiant e WHERE e.email = :email")
    Etudiant findByEmail(String email);

	Etudiant findById(Long id);
	Etudiant findById(int id);
 

}
