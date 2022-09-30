package com.example.sprintBootDemo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void postStudent(@RequestBody Student student){
     studentService.addStudent(student);
    }
     @DeleteMapping(path = "{studentId}")
     public void deleteStudentById(
             @PathVariable("studentId") Long studentId ){
    studentService.deleteStudent(studentId);
        }





}
