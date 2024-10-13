package com.example.data_jpa_test;

import com.example.data_jpa_test.dao.StudentDAOImpl;
import com.example.data_jpa_test.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DataJpaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJpaTestApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAOImpl studentDAO) {
		return runner -> {
//			createStudentAndReadIt(studentDAO);
			findAllStudent(studentDAO);
			filterStudentByName(studentDAO);
		};
	}

	public void filterStudentByName(StudentDAOImpl studentDAO) {
		System.out.println("Fetching student by name Bishal Ghosh...");
		Student student = studentDAO.findStudentByName("Bishal Ghosh");
		System.out.println("Fetching completed");
		System.out.println("Here is the student filtered by name: " + student);
	}

	public void findAllStudent(StudentDAOImpl studentDAO) {
		System.out.println("Fetching all students...");
		List<Student> students = studentDAO.findAllStudent();
		System.out.println("Fetching completed");
		System.out.println("Students: " + students);
	}

	public void createStudentAndReadIt(StudentDAOImpl studentDAO) {

		Student student = new Student("Bishal", "Ghosh", "abc@email.com");
		System.out.println("Creating a student");

		studentDAO.save(student);
		System.out.println("Student created");

		System.out.println("Trying to read the student by its id");
		Student foundStudent = studentDAO.findById(student.getId());

		System.out.println("Student read completed");

		if(foundStudent != null) {
			System.out.println("Student found: " + foundStudent);
		} else {
			System.out.println("No student present with the id: " + student.getId());
		}

	}

	public void createStudents(StudentDAOImpl studentDAO) {

		List<Student> students = List.of(
				new Student("Aditya", "Goyal", "goyal@email.com"),
				new Student("Priyanshu", "Roy", "priyan@email.com"),
				new Student("Vidika", "Paul", "vidika@email.com")
		);
		System.out.println("Creating a students");

		studentDAO.save(students);
		System.out.println("Students created");


	}


}
