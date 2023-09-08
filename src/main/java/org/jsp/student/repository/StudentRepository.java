package org.jsp.student.repository;

import java.util.List;

import org.jsp.student.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByMobile(long mobile);

	Student findByEmail(String email);

	List<Student> findByName(String name);

	List<Student> findByResult(String result);

	List<Student> findByMathsGreaterThanEqualAndEnglishGreaterThanEqual(int marks1, int marks2);

}
