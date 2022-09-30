package com.example.sprintBootDemo.Student;

import org.springframework.boot.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
//import static java.time.Month;
import static java.util.Calendar.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commanLineRunner(StudentRepository studentRepository){

        return args -> {

            Student vishnu = new Student(

                    "Shrrevishnu",
                    "shrrevishnu@gmail.com",
                    LocalDate.of(1997, AUGUST, 12)
            );

            Student rahul = new Student(
                    "Rahul",
                    "rahul@gmail.com",
                    LocalDate.of(1998, SEPTEMBER, 05)

            );

            Student vishal = new Student(
                    "Vishal",
                    "vishal@gmail.com",
                    LocalDate.of(1996, MARCH, 12 )
                    );
            Student mani = new Student(
                    "Mani",
                    "mani@gmail.com",
                    LocalDate.of(1995, MARCH, 7)
            );



            studentRepository.saveAll(
                    List.of(vishnu,rahul, vishal, mani)

            );
        };
    }
}
