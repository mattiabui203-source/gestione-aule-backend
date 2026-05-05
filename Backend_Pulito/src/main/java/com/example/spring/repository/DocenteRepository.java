package com.example.spring.repository;

import com.example.spring.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DocenteRepository extends JpaRepository<Docente, Long> {
    // Per il login
    Optional<Docente> findByEmailAndPassword(String email, String password);
}