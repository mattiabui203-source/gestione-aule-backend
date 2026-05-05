package com.example.spring.repository;

import com.example.spring.model.PrenotazioneStudente;
import com.example.spring.model.Prenotazione;
import com.example.spring.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PrenotazioneStudenteRepository extends JpaRepository<PrenotazioneStudente, Long> {
    // Conta quanti studenti si sono iscritti a una specifica lezione
    long countByPrenotazioneDocente(Prenotazione p);
    
    // Controlla se uno studente è già iscritto a quella lezione
    boolean existsByStudenteAndPrenotazioneDocente(Studente s, Prenotazione p);
    
    // Trova le prenotazioni di un singolo studente
    List<PrenotazioneStudente> findByStudenteId(Long studenteId);
}