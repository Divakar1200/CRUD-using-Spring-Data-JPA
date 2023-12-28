package org.jsp.springdatajpa.controller;

import java.util.List;
import java.util.Optional;

import org.jsp.springdatajpa.dto.Student;
import org.jsp.springdatajpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository repository;
	
	@GetMapping("/students")
	public List<Student> findStudents(){
		List<Student> students = repository.findAll();
		return students;
	}
	
	@PostMapping("/student")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void saveStudent(@RequestBody Student student) {
		repository.save(student);
	}
	
	@GetMapping("/student/{rollnum}")
	public Student findByRollnum(@PathVariable int rollnum) {
		Student student = repository.findById(rollnum).get();
		return student;
	}
	
	@PutMapping("/student/update")
	public Student updateStudent(@RequestBody Student student) {
		Student s = repository.save(student);
		return s;
	}
	
	@DeleteMapping("/student/delete/{rollnum}")
	public void deleteStudent(@PathVariable int rollnum) {
		Student s = repository.findById(rollnum).get();
		repository.delete(s);
	}
}
