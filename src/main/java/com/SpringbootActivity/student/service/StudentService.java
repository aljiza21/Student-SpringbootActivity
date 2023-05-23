package com.SpringbootActivity.student.service;

import com.SpringbootActivity.student.model.Course;
import com.SpringbootActivity.student.model.Student;
import com.SpringbootActivity.student.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getById( Long id) {
        return studentRepository.findById(id);
    }

    public void deleteById(Long id){
        studentRepository.deleteById(id);
    }

    public Student updateById(Long id, Student updatedStudent){
        Student student = studentRepository.findById(id).orElseThrow();
        student.setFirstname(updatedStudent.getFirstname());
        student.setLastname(updatedStudent.getLastname());
        student.setEmail(updatedStudent.getEmail());
        student.setCourse(updatedStudent.getCourse());
        return studentRepository.save(student);
    }


    public Student enroll(Long id, Course course){
        Student student = studentRepository.findById(id).orElseThrow();
        student.setCourse(course);
        return studentRepository.save(student);
    }


    public Student drop(Long id, Course course){
        Student student = studentRepository.findById(id).orElseThrow();
        student.setCourse(null);
        return studentRepository.save(student);
    }
}
