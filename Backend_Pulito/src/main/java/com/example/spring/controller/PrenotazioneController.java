package com.example.spring.controller;

import com.example.spring.model.*;
import com.example.spring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/prenotazioni")
@CrossOrigin(origins = "http://localhost:4200")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    
    @Autowired
    private AulaRepository aulaRepository;

@GetMapping("/docente/{id}") 
public List<Prenotazione> getByDocente(@PathVariable Long id) { 
    return prenotazioneRepository.findByDocenteId(id); 
}

    @PostMapping
    public String prenota(@RequestBody Prenotazione p) {
        if (p.getData().isBefore(LocalDate.now())) {
            return "Errore: Non puoi prenotare nel passato!";
        }

        Aula aula = aulaRepository.findById(p.getAula().getId()).orElse(null);
        if (aula == null) return "Errore: Aula non trovata";

        if (aula.getNome().equalsIgnoreCase("Aula Magna")) {
            if (p.getOra() < 10 || p.getOra() > 12) {
                return "L'Aula Magna è disponibile solo tra le 10:00 e le 12:00!";
            }
        }

        if (prenotazioneRepository.existsByAulaAndDataAndOra(aula, p.getData(), p.getOra())) {
            return "Spiacente, l'aula è già occupata in questa fascia oraria.";
        }

        prenotazioneRepository.save(p);
        return "Prenotazione effettuata con successo!";
    }

    @DeleteMapping("/{id}")
    public void cancella(@PathVariable Long id) {
        prenotazioneRepository.deleteById(id);
    }
}
