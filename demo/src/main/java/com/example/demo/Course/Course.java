package com.example.demo.Course;

import com.example.demo.CourseType.CourseType;
import jakarta.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private Integer credits;
    private String HRGroup;
    private Integer cycle;
    private String VRGroup;

    @ManyToOne
    @JoinColumn(name = "course_type_id")
    private CourseType courseType;
    // Constructores
    public Course() {
    }
    public Course(String name, String code, Integer credits, String HRGroup, Integer cycle, String VRGroup, CourseType courseType) {
        this.name = name;
        this.code = code;
        this.credits = credits;
        this.HRGroup = HRGroup;
        this.cycle = cycle;
        this.VRGroup = VRGroup;
        this.courseType = courseType;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }


    public void setHours(String code, String HRGroup, Integer cycle, String VRGroup) {
        // Implementa la lógica aquí
    }
}
