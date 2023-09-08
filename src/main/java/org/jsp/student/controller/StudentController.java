package org.jsp.student.controller;

import java.util.List;

import org.jsp.student.dto.Student;
import org.jsp.student.helper.ResponseStructure;
import org.jsp.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/students/name/{name}")
	public ResponseEntity<ResponseStructure<List<Student>>> getStudentsByName(@PathVariable String name) {
		return new ResponseEntity<ResponseStructure<List<Student>>>(service.getStudentsByName(name), HttpStatus.FOUND);
	}
	
	@GetMapping("/student/email/{email}")
	public ResponseEntity<ResponseStructure<Student>> getStudentByEmail(@PathVariable String email) {
		return new ResponseEntity<ResponseStructure<Student>>(service.getStudentByEmail(email), HttpStatus.FOUND);
	}
	
	@GetMapping("/student/id/{id}")
	public ResponseEntity<ResponseStructure<Student>> getStudentById(@PathVariable int id) {
		return new ResponseEntity<ResponseStructure<Student>>(service.getStudentById(id), HttpStatus.FOUND);
	}
	
	@GetMapping("/students/result/{result}")
	public ResponseEntity<ResponseStructure<List<Student>>> getStudentsByResult(@PathVariable String result) {
		return new ResponseEntity<ResponseStructure<List<Student>>>(service.getStudentsByResult(result), HttpStatus.FOUND);
	}
	
	@GetMapping("/students/maths/{marks1}/english/{marks2}")
	public ResponseEntity<ResponseStructure<List<Student>>> getStudentsByResult(@PathVariable int marks1,@PathVariable int marks2) {
		return new ResponseEntity<ResponseStructure<List<Student>>>(service.getStudentsByResult(marks1,marks2), HttpStatus.FOUND);
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteStudentById(@PathVariable int id) {
		return new ResponseEntity<ResponseStructure<String>>(service.deleteStudentById(id), HttpStatus.OK);
	}
	
	@PutMapping("/student")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestBody Student student) {
		return new ResponseEntity<ResponseStructure<Student>>(service.updateStudent(student), HttpStatus.CREATED);
	}
	
	@PatchMapping("/student/{id}")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestBody Student student,@PathVariable int id) {
		return new ResponseEntity<ResponseStructure<Student>>(service.updateStudent(student,id), HttpStatus.CREATED);
	}
}
