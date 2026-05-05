package com.example.spring.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "prenotazioni_studenti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrenotazioneStudente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "studente_id", nullable = false)
    private Studente studente;

    @ManyToOne
    @JoinColumn(name = "prenotazione_id", nullable = false)
    private Prenotazione prenotazioneDocente;
}