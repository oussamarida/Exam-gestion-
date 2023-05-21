package com.example.demo.controller;

import com.example.demo.entities.Salle;
import com.example.demo.entities.Surveillant;
import com.example.demo.repository.SalleRepository;
import com.example.demo.repository.SurveillantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salles")
public class SalleController {
    private final SalleRepository salleRepository;
    private final SurveillantRepository surveillantRepository;

    @Autowired
    public SalleController(SalleRepository salleRepository, SurveillantRepository surveillantRepository) {
        this.salleRepository = salleRepository;
        this.surveillantRepository = surveillantRepository;
    }
    
    @GetMapping("/surveillant/{id}")
    public ResponseEntity<?> getSallesBySurveillantId(@PathVariable("id") Long surveillantId) {
        List<Salle> salles = salleRepository.findBySurveillantId(surveillantId);
        return ResponseEntity.ok(salles);
    }

    @GetMapping
    public ResponseEntity<List<Salle>> getAllSalles() {
        List<Salle> salles = salleRepository.findAll();
        return ResponseEntity.ok(salles);
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> getSalleByCode(@PathVariable("code") String code) {
        Salle salle = salleRepository.findByCode(code);
        return salle != null ? ResponseEntity.ok(salle) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Salle> createSalle(@RequestBody Salle salle) {
        Salle createdSalle = salleRepository.save(salle);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSalle);
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> updateSalle(@PathVariable("code") String code, @RequestBody Salle updatedSalle) {
        Salle salle = salleRepository.findByCode(code);
        if (salle != null) {
            salle.setNname(updatedSalle.getNname());
            salle.setSurveillant(updatedSalle.getSurveillant());
            salle.setTables(updatedSalle.getTables());
            salle.setExam(updatedSalle.getExam());

            Salle savedSalle = salleRepository.save(salle);
            return ResponseEntity.ok(savedSalle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteSalle(@PathVariable("code") String code) {
        Salle salle = salleRepository.findByCode(code);
        if (salle != null) {
            salleRepository.delete(salle);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/bySurveillant/{surveillantId}")
    public ResponseEntity<?> getSallesBySurveillant(@PathVariable("surveillantId") Long surveillantId) {
        Surveillant surveillant = surveillantRepository.findById(surveillantId).orElse(null);
        if (surveillant == null) {
            return ResponseEntity.notFound().build();
        }

        List<Salle> salles = salleRepository.findBySurveillant(surveillant);
        return ResponseEntity.ok(salles);
    }
    
    
    @GetMapping("/etudiant/{etudiantId}")
    public ResponseEntity<?> getSallesByEtudiantId(@PathVariable("etudiantId") Long etudiantId) {
        List<Salle> salles = salleRepository.findByTablesEtudiantId(etudiantId);
        return ResponseEntity.ok(salles);
    }
}
