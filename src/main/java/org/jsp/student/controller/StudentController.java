package org.jsp.student.controller;

import java.util.List;

import org.jsp.student.dto.Student;
import org.jsp.student.helper.ResponseStructure;
import org.jsp.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	StudentService service;

	@PostMapping("/student")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<ResponseStructure<Student>>(service.saveStudent(student), HttpStatus.CREATED);
	}
	
	@PostMapping("/students")
	public ResponseEntity<ResponseStructure<List<Student>>> saveStudents(@RequestBody List<Student> students) {
		return new ResponseEntity<ResponseStructure<List<Student>>>(service.saveStudents(students), HttpStatus.CREATED);
	}
	
	@GetMapping("/students")
	public ResponseEntity<ResponseStructure<List<Student>>> getStudents() {
		return new ResponseEntity<ResponseStructure<List<Student>>>(service.getStudents(), HttpStatus.FOUND);
	}
	
	@GetMapping("/student")
	public ResponseEntity<ResponseStructure<List<Student>>> getStudentsByName(@RequestParam String name) {
		return new ResponseEntity<ResponseStructure<List<Student>>>(service.getStudentsByName(name), HttpStatus.FOUND);
	}
	
	@GetMapping("/student/name/{name}")
	public ResponseEntity<ResponseStructure<List<Student>>> getStudentsByEmail(@PathVariable String name) {
		return new ResponseEntity<ResponseStructure<List<Student>>>(service.getStudentsByName(name), HttpStatus.FOUND);
	}
	
	@GetMapping("/student/email/{email}")
	public ResponseEntity<ResponseStructure<Student>> getStudentByEmail(@PathVariable String email) {
		return new ResponseEntity<ResponseStructure<Student>>(service.getStudentByEmail(email), HttpStatus.FOUND);
	}
}
