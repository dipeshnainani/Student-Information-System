package edu.rit.datasec.Group3Project.service;

import java.util.List;

import edu.rit.datasec.Group3Project.bo.Instructor;
import edu.rit.datasec.Group3Project.bo.InstructorCourse;
import edu.rit.datasec.Group3Project.dao.InstructorDAO;

public class InstructorService {

	private static InstructorService INSTRUCTOR_SERVICE;
	private final InstructorDAO instructorDao;

	private InstructorService() {
		instructorDao = InstructorDAO.getInstance();
	}

	public static InstructorService getInstance() {
		if (INSTRUCTOR_SERVICE == null) {
			INSTRUCTOR_SERVICE = new InstructorService();
		}
		return INSTRUCTOR_SERVICE;
	}

	public Instructor getInstructorInfo(String login) {
		return instructorDao.getInstructorInfo(login);
	}

	public List<InstructorCourse> getInstructorCourseInfo(String login) {
		return instructorDao.getInstructorCourseInfo(login);
	}

}
