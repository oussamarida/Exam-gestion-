package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Filiere;
import com.example.demo.repository.FiliereRepository;

@RestController
@RequestMapping("/filieres")
public class FiliereController {
	@Autowired
	private FiliereRepository filiereRepository;



	
}
