package com.example.spring.repository;

import com.example.spring.model.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    
    // Questo metodo dice a Spring: "Cerca nella tabella prenotazioni id tabella = id che ti passo e dammi tutte le prenotazioni che hanno quell'id"
    
    List<Prenotazione> findByDocenteId(Long id); 
    
    boolean existsByAulaAndDataAndOra(com.example.spring.model.Aula aula, java.time.LocalDate data, int ora);
}