package com.example.spring.controller;

import com.example.spring.model.*;
import com.example.spring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/studenti")
@CrossOrigin(origins = "http://localhost:4200")
public class StudenteController {

    @Autowired private PrenotazioneRepository prenotazioneRepo;
    @Autowired private PrenotazioneStudenteRepository prenoStudenteRepo;
    @Autowired private StudenteRepository studenteRepo;

    // 1. Manda ad Angular la lista delle lezioni con i POSTI SCALATI
    @GetMapping("/lezioni-disponibili")
    public List<Map<String, Object>> getLezioniDisponibili() {
        List<Prenotazione> tutteLeLezioni = prenotazioneRepo.findAll();
        List<Map<String, Object>> risultato = new ArrayList<>();

        for (Prenotazione lezione : tutteLeLezioni) {
            // Contiamo quanti studenti si sono già prenotati
            long occupati = prenoStudenteRepo.countByPrenotazioneDocente(lezione);
            long postiDisponibili = lezione.getAula().getCapienza() - occupati;

         
            Map<String, Object> mappa = new HashMap<>();
            mappa.put("idPrenotazione", lezione.getId());
            mappa.put("docente", lezione.getDocente().getNome() + " " + lezione.getDocente().getCognome());
            mappa.put("materia", "Lezione in " + lezione.getAula().getNome());
            mappa.put("data", lezione.getData());
            mappa.put("ora", lezione.getOra());
            mappa.put("postiTotali", lezione.getAula().getCapienza());
            mappa.put("postiDisponibili", postiDisponibili); // ECCO LA SOTTRAZIONE!
            
            risultato.add(mappa);
        }
        return risultato;
    }

    // 2. Lo studente prenota il posto
    @PostMapping("/prenota-posto")
    public String prenotaPosto(@RequestParam Long idStudente, @RequestParam Long idPrenotazione) {
        Studente s = studenteRepo.findById(idStudente).orElse(null);
        Prenotazione p = prenotazioneRepo.findById(idPrenotazione).orElse(null);

        if (s == null || p == null) return "Errore dati.";

        if (prenoStudenteRepo.existsByStudenteAndPrenotazioneDocente(s, p)) {
            return "Sei già iscritto a questa lezione!";
        }

        long occupati = prenoStudenteRepo.countByPrenotazioneDocente(p);
        if (occupati >= p.getAula().getCapienza()) {
            return "Spiacenti, i posti sono esauriti!";
        }

        PrenotazioneStudente nuovaPreno = new PrenotazioneStudente();
        nuovaPreno.setStudente(s);
        nuovaPreno.setPrenotazioneDocente(p);
        prenoStudenteRepo.save(nuovaPreno);

        return "Posto prenotato con successo!";
    }

    // 3. Lo studente vede a cosa si è iscritto
    @GetMapping("/{idStudente}/mie-prenotazioni")
    public List<PrenotazioneStudente> getMiePrenotazioni(@PathVariable Long idStudente) {
        return prenoStudenteRepo.findByStudenteId(idStudente);
    }
    
    // 4. Lo studente disdice il posto (il posto torna libero)
    @DeleteMapping("/cancella-posto/{idPrenotazioneStudente}")
    public void cancellaPosto(@PathVariable Long idPrenotazioneStudente) {
        prenoStudenteRepo.deleteById(idPrenotazioneStudente);
    }
}