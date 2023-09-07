package org.jsp.student.dao;

import java.util.List;

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

	public List<Student> saveStudents(List<Student> students) {
		return repository.saveAll(students);
	}

	public List<Student> getStudents() {
		return repository.findAll();
	}

	public List<Student> getStudentByName(String name) {
		return repository.findByName(name);
	}


}
