package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.ProfesseurRepository;

@RestController
@RequestMapping("/professeurs")
public class ProfesseurController {
	@Autowired
	private ProfesseurRepository professeurRepository;
}
