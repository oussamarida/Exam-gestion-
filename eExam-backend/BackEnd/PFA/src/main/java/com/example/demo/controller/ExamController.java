package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Exam;
import com.example.demo.repository.EtudiantRepository;
import com.example.demo.repository.ExamRepository;

@RestController
@RequestMapping("/exams")
public class ExamController {
	@Autowired
	private ExamRepository examRepository;
	@Autowired
	private EtudiantRepository etudiantRepository;

	@GetMapping("/all")
	public List<Exam> allstudents() {

		return examRepository.findAll();
	}

	@PutMapping("/addstudent/{eid}")
	    public String addstudent( @PathVariable("eid") int eid, @RequestParam  String xid) {
		Etudiant etudiant = etudiantRepository.findById(eid);
		Exam exam = examRepository.findByCode(xid);
		etudiant.getExams().add(exam);
		etudiantRepository.save(etudiant);
		
		
		
		
	        return "done";
	    }

}
