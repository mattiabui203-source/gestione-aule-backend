package com.example.spring.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "docenti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cognome;
    
    @Column(unique = true) // L'email deve essere unica per il login
    private String email;
    
    private String password;

    // Relazione: Un docente può avere molte prenotazioni
    @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Prenotazione> prenotazioni;
}
