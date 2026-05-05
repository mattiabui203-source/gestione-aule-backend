package com.example.spring.repository;

import com.example.spring.model.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface AulaRepository extends JpaRepository<Aula, Long> {
    @Query("SELECT a FROM Aula a WHERE a.capienza >= :minCapienza AND a.id NOT IN " +
           "(SELECT p.aula.id FROM Prenotazione p WHERE p.data = :data AND p.ora = :ora)")
    List<Aula> findDisponibili(@Param("data") LocalDate data, 
                               @Param("ora") int ora, 
                               @Param("minCapienza") int minCapienza);
}

