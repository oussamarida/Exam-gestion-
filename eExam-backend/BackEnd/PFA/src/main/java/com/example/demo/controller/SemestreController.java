package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Semestre;
import com.example.demo.repository.SemestreRepository;

@RestController
@RequestMapping("/semestres")
public class SemestreController {
	@Autowired
	private SemestreRepository semestreRepository;
	


	
}
