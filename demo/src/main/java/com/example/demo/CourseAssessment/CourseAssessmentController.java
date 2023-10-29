package com.example.demo.CourseAssessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course_assessments")
public class CourseAssessmentController {

    private final CourseAssessmentRepository courseAssessmentRepository;

    @Autowired
    public CourseAssessmentController(CourseAssessmentRepository courseAssessmentRepository) {
        this.courseAssessmentRepository = courseAssessmentRepository;
    }

    @GetMapping
    public List<CourseAssessment> getAllCourseAssessments() {
        return courseAssessmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public CourseAssessment getCourseAssessmentById(@PathVariable Long id) {
        return courseAssessmentRepository.findById(id).orElse(null);
    }

    @PostMapping
    public CourseAssessment createCourseAssessment(@RequestBody CourseAssessment courseAssessment) {
        return courseAssessmentRepository.save(courseAssessment);
    }

    @PutMapping("/{id}")
    public CourseAssessment updateCourseAssessment(@PathVariable Long id, @RequestBody CourseAssessment courseAssessment) {
        if (courseAssessmentRepository.existsById(id)) {
            courseAssessment.setId(id);
            return courseAssessmentRepository.save(courseAssessment);
        } else {
            return null; // Puedes manejar la respuesta en caso de que el registro no exista
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCourseAssessment(@PathVariable Long id) {
        courseAssessmentRepository.deleteById(id);
    }
}