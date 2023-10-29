package com.example.demo.CourseType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course_types")
public class CourseTypeController {

    private final CourseTypeRepository courseTypeRepository;

    @Autowired
    public CourseTypeController(CourseTypeRepository courseTypeRepository) {
        this.courseTypeRepository = courseTypeRepository;
    }

    @GetMapping
    public List<CourseType> getAllCourseTypes() {
        return courseTypeRepository.findAll();
    }

    @GetMapping("/{id}")
    public CourseType getCourseTypeById(@PathVariable Long id) {
        return courseTypeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public CourseType createCourseType(@RequestBody CourseType courseType) {
        return courseTypeRepository.save(courseType);
    }

    @PutMapping("/{id}")
    public CourseType updateCourseType(@PathVariable Long id, @RequestBody CourseType courseType) {
        if (courseTypeRepository.existsById(id)) {
            courseType.setId(id);
            return courseTypeRepository.save(courseType);
        } else {
            return null; // Puedes manejar la respuesta en caso de que el registro no exista
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCourseType(@PathVariable Long id) {
        courseTypeRepository.deleteById(id);
    }
}