package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.MatiereRepository;

@RestController
@RequestMapping("/matieres")
public class MatiereController {
	@Autowired
	private MatiereRepository matiereRepository;
}
