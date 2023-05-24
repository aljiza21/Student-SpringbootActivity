package com.SpringbootActivity.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.SpringbootActivity.student.model.Course;
import com.SpringbootActivity.student.repository.CourseRepository;

public class CourseServiceImp implements CourseService{
    
    @Autowired
	private CourseRepository courseRepository;

    @Override
    public Course addCourse(Course course){
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> getCourseById(Long id){
        return courseRepository.findById(id);
    }

    @Override
    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }

    @Override
    public Course updatedCourse( Long id, Course updatedCourse){
        Course course = courseRepository.findById(id).orElseThrow();
        course.setName(updatedCourse.getName());
        return courseRepository.save(course);
    }

}
