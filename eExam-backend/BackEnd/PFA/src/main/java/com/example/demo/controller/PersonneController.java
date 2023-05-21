package com.example.demo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Personne;
import com.example.demo.repository.PersonneRepository;

@RestController
@RequestMapping("/personnes")
public class PersonneController {
	@Autowired
	private PersonneRepository personneRepository;
	
	@PostMapping("/save")
	public int createPersonne(@RequestBody Personne personneRequest) {
		Personne  optionalPersonne = null;
	     optionalPersonne = personneRepository.findByCne(personneRequest.getCne());
	    if (optionalPersonne != null) {
	        return optionalPersonne.getId();
	    }
	    Personne personne = new Personne(personneRequest.getCne(), personneRequest.getNom(), personneRequest.getPrenom());
	    Personne savedPersonne = personneRepository.save(personne);
	    Personne optionalPersonne2 = personneRepository.findByCne(personneRequest.getCne());
	    return optionalPersonne2.getId();
	}


	
}
