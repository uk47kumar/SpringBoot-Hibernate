package com.example.hibernate;

import com.example.hibernate.dao.StudentDAO;
import com.example.hibernate.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringBootHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHibernateApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {

//            createStudent(studentDAO);

            createMultipleStudents(studentDAO);

//            readStudent(studentDAO);

//            queryForStudents(studentDAO);

//            queryForStudentsByLastName(studentDAO);

//            updateStudent(studentDAO);

//            deleteStudent(studentDAO);

//            deleteAllStudents(studentDAO);

        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students...");
        int numRowDeleted = studentDAO.deleteAll();
        System.out.println("Deleted row count: " + numRowDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 6;
        System.out.println("Deleting Student id:" + studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        // retrieve the student based on the id: primary key
        int studentId = 6;
        System.out.println("Getting the student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        // change first name to "john"
        System.out.println("Updating the student...");
        myStudent.setFirstName("john");

        // update the student
        studentDAO.update(myStudent);

        // display the update student
        System.out.println("Updated Student: " + myStudent);

    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        // get list of students
        List<Student> studentList = studentDAO.findByLastName("kumari");

        // display list of students
        for (Student tempStudent : studentList) {
            System.out.println(tempStudent);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        // get list of students
        List<Student> studentList = studentDAO.findAll();

        // display list of students
        for (Student tempStudent : studentList) {
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        // create a student object
        System.out.println("Creating Student Object");
        Student tempStudent = new Student("mickey", "mouse", "mickey@gmail.com");

        // save the student
        System.out.println("Save the Student");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved Student id: " + tempStudent.getId());

        // retrieve student based on the id: primary key
        Student studentId = studentDAO.findById(5);

        // display student
        System.out.println("Student retrieve from database: " + studentId);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating 3 Students object...");
        Student tempStudent1 = new Student("annu", "kumari", "ak47kumar@gmail.com");
        Student tempStudent2 = new Student("nischal", "kumar", "nk47kumar@gmail.com");
        Student tempStudent3 = new Student("ashish", "kumar", "ak4kumar@gmail.com");

        // save the student object
        System.out.println("Saving the Students...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("Creating new Student object...");
        Student tempStudent = new Student("ujjwal", "kumar", "uk47kumar@gmail.com");

        // save the student object
        studentDAO.save(tempStudent);

        // display id of the save student
        System.out.println("saved Student. Generated id: " + tempStudent.getId());

    }
}
