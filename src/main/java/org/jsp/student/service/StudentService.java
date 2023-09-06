package org.jsp.student.service;

import org.jsp.student.dao.StudentDao;
import org.jsp.student.dto.Student;
import org.jsp.student.exception.ShouldNotRepeatExecption;
import org.jsp.student.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	StudentDao dao;

	public ResponseStructure<Student> saveStudent(Student student) {
		if (dao.fetchStudent(student.getMobile()) == null && dao.fetchStudent(student.getEmail()) == null) {
			student.setPercentage((student.getEnglish() + student.getMaths() + student.getScience()) / 3.0);

			if (student.getPercentage() < 35 || student.getMaths() < 35 || student.getScience() < 35
					|| student.getEnglish() < 35)
				student.setResult("Fail");
			else {
				if (student.getPercentage() > 85)
					student.setResult("Distinction");
				else if (student.getPercentage() > 60)
					student.setResult("FirstClass");
				else
					student.setResult("SecondClass");
			}

			ResponseStructure<Student> structure = new ResponseStructure<Student>();
			structure.setData(dao.saveStudent(student));
			structure.setMessage("Data Inserted Success");
			structure.setStatus(HttpStatus.CREATED.value());
			return structure;
		} else {
			if (dao.fetchStudent(student.getMobile()) == null)
				throw new ShouldNotRepeatExecption(student.getEmail() + " Should Not Repeat");
			else
				throw new ShouldNotRepeatExecption(student.getMobile() + " Should Not Repeat");
		}
	}

}
