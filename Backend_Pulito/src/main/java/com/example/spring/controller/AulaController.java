package com.example.spring.controller;

import com.example.spring.model.Aula;
import com.example.spring.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/aule")
@CrossOrigin(origins = "http://localhost:4200")
public class AulaController {

    @Autowired
    private AulaRepository aulaRepository;

    @GetMapping
    public List<Aula> getAllAule() {
        return aulaRepository.findAll();
    }

    @PostMapping
    public Aula createAula(@RequestBody Aula aula) {
        return aulaRepository.save(aula);
    }

    @DeleteMapping("/{id}")
    public void deleteAula(@PathVariable Long id) {
        aulaRepository.deleteById(id);
    }

    // Endpoint mancante per i filtri del docente
    @GetMapping("/disponibili")
    public List<Aula> getAuleLibere(
            @RequestParam LocalDate data, 
            @RequestParam int ora, 
            @RequestParam int minCapienza) {
        return aulaRepository.findDisponibili(data, ora, minCapienza);
    }
}
