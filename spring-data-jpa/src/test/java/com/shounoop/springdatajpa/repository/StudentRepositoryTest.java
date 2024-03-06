package com.shounoop.springdatajpa.repository;

import com.shounoop.springdatajpa.entity.Guardian;
import com.shounoop.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder().emailId("hmt@gmail.com").firstName("Shounoop").lastName("Saha").build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder().name("Sudip Saha2").email("niki2@gmail.com").mobile("08432432432").build();

        Student student = Student.builder().emailId("hmt2@gmail.com").firstName("Shounoop2").lastName("Saha2").guardian(guardian).build();

        studentRepository.save(student);

    }

    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Shounoop");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("Shoun");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByLastNameNotNull() {
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Sudip Saha");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("hmt2@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress() {
        String studentFirstName = studentRepository.getStudentFirstNameByEmailAddress("hmt2@gmail.com");
        System.out.println("studentFirstName = " + studentFirstName);
    }

    @Test
    public void printStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("hmt2@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentByEmailAddressNativeNameParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNameParam("hmt2@gmail.com");
        System.out.println("student = " + student);
    }
}
