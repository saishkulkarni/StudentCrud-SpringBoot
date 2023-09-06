package org.jsp.student.dao;

import org.jsp.student.dto.Student;
import org.jsp.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

	@Autowired
	StudentRepository repository;

	public Student saveStudent(Student student) {
		return repository.save(student);
	}

	public Student fetchStudent(long mobile) {
		return repository.findByMobile(mobile);
	}

	public Student fetchStudent(String email) {
		return repository.findByEmail(email);
	}

}
