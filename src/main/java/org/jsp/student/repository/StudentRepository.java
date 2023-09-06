package org.jsp.student.repository;

import org.jsp.student.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByMobile(long mobile);

	Student findByEmail(String email);

}
