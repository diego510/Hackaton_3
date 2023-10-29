package com.example.demo.Periodo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Long> {
    // Puedes agregar consultas personalizadas aquí si es necesario
}