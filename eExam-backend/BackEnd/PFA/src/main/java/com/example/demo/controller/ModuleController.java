package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Filiere;
import com.example.demo.entities.Semestre;
import com.example.demo.entities.Module;
import com.example.demo.repository.ModuleRepository;
import com.example.demo.repository.SemestreRepository;

@RestController
@RequestMapping("/modules")
public class ModuleController {
	@Autowired
	private ModuleRepository moduleRepository;
	@Autowired
	private SemestreRepository semestreRepository;



}
