package com.example.demo.CourseAssessment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseAssessmentRepository extends JpaRepository<CourseAssessment, Long> {
    // Puedes agregar consultas personalizadas aquí si es necesario
}