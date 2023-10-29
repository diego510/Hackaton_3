package com.example.demo.CourseAssessmentDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course_assessment_details")
public class CourseAssessmentDetailsController {

    private final CourseAssessmentDetailsRepository courseAssessmentDetailsRepository;

    @Autowired
    public CourseAssessmentDetailsController(CourseAssessmentDetailsRepository courseAssessmentDetailsRepository) {
        this.courseAssessmentDetailsRepository = courseAssessmentDetailsRepository;
    }

    // Operación GET para recuperar todos los detalles de la evaluación del curso
    @GetMapping
    public ResponseEntity<List<CourseAssessmentDetails>> getAllCourseAssessmentDetails() {
        List<CourseAssessmentDetails> details = courseAssessmentDetailsRepository.findAll();
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

    // Operación GET para recuperar detalles de la evaluación del curso por ID
    @GetMapping("/{id}")
    public ResponseEntity<CourseAssessmentDetails> getCourseAssessmentDetailsById(@PathVariable Long id) {
        CourseAssessmentDetails details = courseAssessmentDetailsRepository.findById(id).orElse(null);
        if (details != null) {
            return new ResponseEntity<>(details, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Operación POST para crear un nuevo detalle de evaluación del curso
    @PostMapping
    public ResponseEntity<CourseAssessmentDetails> createCourseAssessmentDetails(@RequestBody CourseAssessmentDetails details) {
        CourseAssessmentDetails createdDetails = courseAssessmentDetailsRepository.save(details);
        return new ResponseEntity<>(createdDetails, HttpStatus.CREATED);
    }

    // Operación PUT para actualizar detalles de la evaluación del curso por ID
    @PutMapping("/{id}")
    public ResponseEntity<CourseAssessmentDetails> updateCourseAssessmentDetails(@PathVariable Long id, @RequestBody CourseAssessmentDetails details) {
        if (courseAssessmentDetailsRepository.existsById(id)) {
            details.setId(id);
            CourseAssessmentDetails updatedDetails = courseAssessmentDetailsRepository.save(details);
            return new ResponseEntity<>(updatedDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Operación DELETE para eliminar detalles de la evaluación del curso por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseAssessmentDetails(@PathVariable Long id) {
        if (courseAssessmentDetailsRepository.existsById(id)) {
            courseAssessmentDetailsRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
