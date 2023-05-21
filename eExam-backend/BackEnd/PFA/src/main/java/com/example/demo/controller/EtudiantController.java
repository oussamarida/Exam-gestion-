package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.Etudiant;

import com.example.demo.repository.EtudiantRepository;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {
	@Autowired
	private EtudiantRepository etudiantRepository;

	
	 @GetMapping("/{id}")
	    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable("id") int id) {
	        Etudiant etudiant = etudiantRepository.findById(id);

	        if (etudiant != null) {
	            return ResponseEntity.ok(etudiant);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }
	 
	 @GetMapping("/{id}/")
	    public ResponseEntity<String> updateAdminPassword(
	            @PathVariable("id") Long id,
	            @RequestParam String password
	    ) {
	        Etudiant etudiant = etudiantRepository.findById(id);
	        etudiant.setPassword(password);
	        etudiantRepository.save(etudiant);

	        return new ResponseEntity<>("Password updated successfully", HttpStatus.OK);
	    }

	 @GetMapping("/all")
	    public List<Etudiant> allstudents() {
	   
	        return etudiantRepository.findAll();
	    }


}


   
   





