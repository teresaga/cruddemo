package org.example.cruddemo;

import org.example.cruddemo.dao.StudentDAO;
import org.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            //createStudent(studentDAO);

            //createMultipleStudents(studentDAO);

            //readStudent(studentDAO);

            queryForStudents(studentDAO);
        };
    }

    private void queryForStudents(StudentDAO studentDAO) {
        // get list of students
        List<Student> students = studentDAO.findAll();

        // display list of students
        for (Student tempStudent : students) {
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        // create a student object
        System.out.println("Creating new student object...");
        Student temptStudent = new Student("Rosa", "Aguilar", "rosa@gmail.com");

        // save the student object
        System.out.println("Saving the student...");
        studentDAO.save(temptStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + temptStudent.getId());

        // retrieve student based on the id: primary key
        System.out.println("\nRetrieving student with id: " + temptStudent.getId());

        Student myStudent = studentDAO.findById(temptStudent.getId());

        System.out.println("Found the student: " + myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        // create multiple students
        System.out.println("Creating 3 new student objects...");
        Student temptStudent1 = new Student("Jose", "Torres", "jose@gmail.com");
        Student temptStudent2 = new Student("Kiel", "Crew", "kiel@gmail.com");
        Student temptStudent3 = new Student("Ariel", "Hugson", "ariel@gmail.com");

        // save the student objects
        System.out.println("Saving the students...");
        studentDAO.save(temptStudent1);
        studentDAO.save(temptStudent2);
        studentDAO.save(temptStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new student object...");
        Student temptStudent = new Student("Teresa", "Gal", "teresa@gmail.com");

        // save the student object
        System.out.println("Saving the student...");
        studentDAO.save(temptStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + temptStudent.getId());
    }

}
