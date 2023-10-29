package com.example.demo.CourseAssessmentDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseAssessmentDetailsRepository extends JpaRepository<CourseAssessmentDetails,Long> {
}
