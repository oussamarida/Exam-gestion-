package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Exam;
import com.example.demo.entities.Matiere;

public interface ExamRepository extends JpaRepository<Exam, Integer> {

	 @Query("SELECT e FROM Exam e JOIN e.matiere m WHERE m = :matiere")
	    Exam findByMatiere(@Param("matiere") Matiere matiere);

	Exam findByCode(String code);





}
