package com.example.spring.repository;

import com.example.spring.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StudenteRepository extends JpaRepository<Studente, Long> {
    Optional<Studente> findByEmailAndPassword(String email, String password);
}