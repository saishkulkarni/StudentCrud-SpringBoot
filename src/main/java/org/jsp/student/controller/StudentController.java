package org.jsp.student.controller;

import org.jsp.student.dto.Student;
import org.jsp.student.helper.ResponseStructure;
import org.jsp.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	StudentService service;

	@PostMapping("/student")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<ResponseStructure<Student>>(service.saveStudent(student), HttpStatus.CREATED);
	}
}
