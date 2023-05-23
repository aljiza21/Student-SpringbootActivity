package com.SpringbootActivity.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.SpringbootActivity.student.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
    
}
