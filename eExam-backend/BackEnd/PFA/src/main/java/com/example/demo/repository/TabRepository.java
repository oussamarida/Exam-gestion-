package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Salle;
import com.example.demo.entities.Tab;

public interface TabRepository extends JpaRepository<Tab, Integer> {
	Tab findByNum(String num);

	@Query("SELECT t FROM Tab t WHERE t.num = :num AND t.salle = :salle AND t.etudiant = :etudiant ")
	Tab findByall(@Param("num") String num, @Param("salle") Salle salle,@Param("etudiant") Etudiant etudiant);
	
    Tab findById(int id);
}
