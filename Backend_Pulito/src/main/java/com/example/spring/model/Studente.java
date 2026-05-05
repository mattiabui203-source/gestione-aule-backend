package com.example.spring.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "studenti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Studente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cognome;
    
    @Column(unique = true)
    private String email;
    
    private String password;
}