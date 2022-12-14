package com.example.sprintBootDemo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {

        Optional<Student> optionalStudent = studentRepository.findStudentbyEmail(student.getEmail());
        if(optionalStudent.isPresent()){
             throw new IllegalStateException("Email was already present");
        }
        studentRepository.save(student);
        //System.out.println(student);
    }

    public void deleteStudent(Long studentId){
     boolean exists = studentRepository.existsById(studentId);
     if(!exists){
         throw new IllegalStateException("Student with id"+studentId+"does not exist");
     }

        studentRepository.deleteById(studentId);
    }

}
