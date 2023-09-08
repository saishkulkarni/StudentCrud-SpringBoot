package org.jsp.student.service;

import java.util.List;

import org.jsp.student.dao.StudentDao;
import org.jsp.student.dto.Student;
import org.jsp.student.exception.DataNotFoundExecption;
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

	public ResponseStructure<List<Student>> saveStudents(List<Student> students) {
		for (Student student : students) {
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
			} else {
				if (dao.fetchStudent(student.getMobile()) == null)
					throw new ShouldNotRepeatExecption(student.getEmail() + " Should Not Repeat");
				else
					throw new ShouldNotRepeatExecption(student.getMobile() + " Should Not Repeat");
			}
		}
		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
		structure.setData(dao.saveStudents(students));
		structure.setMessage("Data Inserted Success");
		structure.setStatus(HttpStatus.CREATED.value());
		return structure;
	}

	public ResponseStructure<List<Student>> getStudents() {
		List<Student> list = dao.getStudents();
		if (list.isEmpty())
			throw new DataNotFoundExecption();
		else {
			ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
			structure.setData(list);
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			return structure;
		}
	}

	public ResponseStructure<List<Student>> getStudentsByName(String name) {
		List<Student> list = dao.getStudentByName(name);
		if (list.isEmpty())
			throw new DataNotFoundExecption("Data Not Found With Name- " + name);
		else {
			ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
			structure.setData(list);
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			return structure;
		}
	}

	public ResponseStructure<Student> getStudentByEmail(String email) {
		Student student = dao.fetchStudent(email);
		if (student == null)
			throw new DataNotFoundExecption("Data Not Found With Email- " + email);
		else {
			ResponseStructure<Student> structure = new ResponseStructure<Student>();
			structure.setData(student);
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			return structure;
		}
	}

	public ResponseStructure<Student> getStudentById(int id) {
		Student student = dao.fetchStudentById(id);

		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		structure.setData(student);
		structure.setMessage("Data Found");
		structure.setStatus(HttpStatus.FOUND.value());
		return structure;
	}

	public ResponseStructure<List<Student>> getStudentsByResult(String result) {
		List<Student> list = dao.getStudentByResult(result);
		if (list.isEmpty())
			throw new DataNotFoundExecption("Data Not Found With Result- " + result);
		else {
			ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
			structure.setData(list);
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			return structure;
		}
	}

	public ResponseStructure<List<Student>> getStudentsByResult(int marks1, int marks2) {
		List<Student> list = dao.getStudentByResult(marks1, marks2);
		if (list.isEmpty())
			throw new DataNotFoundExecption("Data Not Found With Given Marks");
		else {
			ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
			structure.setData(list);
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			return structure;
		}
	}

	public ResponseStructure<String> deleteStudentById(int id) {
		Student student = dao.fetchStudentById(id);
		dao.delete(id);
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData("Data Deleted with Id- " + id);
		structure.setMessage("Data Deleted");
		structure.setStatus(HttpStatus.OK.value());
		return structure;
	}

	public ResponseStructure<Student> updateStudent(Student student) {
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
		structure.setMessage("Data Updated Success");
		structure.setStatus(HttpStatus.CREATED.value());
		return structure;
	}

	public ResponseStructure<Student> updateStudent(Student student, int id) {
		dao.fetchStudentById(id);
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
		structure.setMessage("Data Updated Success");
		structure.setStatus(HttpStatus.CREATED.value());
		return structure;
	}
}
