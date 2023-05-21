package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Surveillant;
import com.example.demo.repository.SurveillantRepository;

@RestController
@RequestMapping("/surveillants")
public class SurveillantController {
    private final SurveillantRepository surveillantRepository;

    @Autowired
    public SurveillantController(SurveillantRepository surveillantRepository) {
        this.surveillantRepository = surveillantRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAllSurveillants() {
        return ResponseEntity.ok(surveillantRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSurveillantById(@PathVariable("id") Long id) {
        return surveillantRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createSurveillant(@RequestBody Surveillant surveillant) {
        Surveillant savedSurveillant = surveillantRepository.save(surveillant);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSurveillant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSurveillant(@PathVariable("id") Long id, @RequestBody Surveillant updatedSurveillant) {
        return surveillantRepository.findById(id)
                .map(existingSurveillant -> {
                    existingSurveillant.setCne(updatedSurveillant.getCne());
                    existingSurveillant.setNom(updatedSurveillant.getNom());
                    existingSurveillant.setPrenom(updatedSurveillant.getPrenom());
                    existingSurveillant.setCode(updatedSurveillant.getCode());
                    existingSurveillant.setEmail(updatedSurveillant.getEmail());
                    // Update the password only if it's not null or empty
                    if (updatedSurveillant.getPassword() != null && !updatedSurveillant.getPassword().isEmpty()) {
                        existingSurveillant.setPassword(updatedSurveillant.getPassword());
                    }
                    Surveillant savedSurveillant = surveillantRepository.save(existingSurveillant);
                    return ResponseEntity.ok(savedSurveillant);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSurveillant(@PathVariable("id") Long id) {
        return surveillantRepository.findById(id)
                .map(surveillant -> {
                    surveillantRepository.delete(surveillant);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
