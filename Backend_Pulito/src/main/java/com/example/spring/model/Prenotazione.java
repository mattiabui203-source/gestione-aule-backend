package com.example.spring.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "prenotazioni")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;
    private int ora;

    @ManyToOne
    @JoinColumn(name = "docente_id", nullable = false)
    private Docente docente; 

    @ManyToOne
    @JoinColumn(name = "aula_id", nullable = false)
    private Aula aula;
}