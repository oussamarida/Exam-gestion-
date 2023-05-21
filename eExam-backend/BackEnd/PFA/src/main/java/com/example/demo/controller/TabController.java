package com.example.demo.controller;

import com.example.demo.entities.Tab;
import com.example.demo.entities.Surveillant;
import com.example.demo.repository.TabRepository;
import com.example.demo.repository.SurveillantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/tabs")
public class TabController {

    @Autowired
    private TabRepository tabRepository;

    @PostMapping
    public Tab saveTab(@RequestBody Tab tab) {
        return tabRepository.save(tab);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Tab> updateTab(@PathVariable("id") Integer id, @RequestBody Tab updatedTab) {
        Optional<Tab> optionalTab = tabRepository.findById(id);
        if (optionalTab.isPresent()) {
            Tab existingTab = optionalTab.get();
            existingTab.setAbsence(updatedTab.getAbsence());

            Tab savedTab = tabRepository.save(existingTab);
            return new ResponseEntity<>(savedTab, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @GetMapping
    public Iterable<Tab> getAllTabs() {
        return tabRepository.findAll();
    }


}