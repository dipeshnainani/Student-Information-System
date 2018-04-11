package edu.rit.datasec.Group3Project.service;

import java.util.List;

import edu.rit.datasec.Group3Project.bo.Student;
import edu.rit.datasec.Group3Project.bo.StudentCourse;
import edu.rit.datasec.Group3Project.dao.StudentDAO;

public class StudentService {

	private static StudentService STUDENT_SERVICE;
	private final StudentDAO studentDao;

	private StudentService() {
		studentDao = StudentDAO.getInstance();
	}

	public static StudentService getInstance() {
		if (STUDENT_SERVICE == null) {
			STUDENT_SERVICE = new StudentService();
		}
		return STUDENT_SERVICE;
	}

	public Student getStudentInfo(String login) {
		return studentDao.getStudentInfo(login);
	}

	public List<StudentCourse> getStudentCourseInfo(String login) {

		return studentDao.getStudentCourseInfo(login);

	}

}
