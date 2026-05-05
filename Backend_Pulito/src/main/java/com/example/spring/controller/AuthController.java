package com.example.spring.controller;

import com.example.spring.model.Docente;
import com.example.spring.model.Studente;
import com.example.spring.repository.DocenteRepository;
import com.example.spring.repository.StudenteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    private StudenteRepository studenteRepository;

    @PostMapping("/login")
    public Docente login(@RequestBody Docente d) {
        return docenteRepository.findByEmailAndPassword(d.getEmail(), d.getPassword()).orElse(null); // Ritorna il docente se trovato, altrimenti null
    }

    @PostMapping("/login/studente")
    public Studente loginStudente(@RequestBody Studente s) {
        return studenteRepository.findByEmailAndPassword(s.getEmail(), s.getPassword()).orElse(null);
    }
}
