package edu.rit.datasec.Group3Project.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.rit.datasec.Group3Project.bo.Instructor;
import edu.rit.datasec.Group3Project.bo.InstructorCourse;
import edu.rit.datasec.Group3Project.hibernate.util.HibernateUtil;

public class InstructorDAO {

	private static InstructorDAO INSTRUCTOR_DAO;

	private InstructorDAO() {

	}

	public static InstructorDAO getInstance() {
		if (INSTRUCTOR_DAO == null) {
			INSTRUCTOR_DAO = new InstructorDAO();
		}
		return INSTRUCTOR_DAO;
	}

	@SuppressWarnings("unchecked")
	public Instructor getInstructorInfo(String login) {
		String statement = "from Instructor i WHERE i.credentials.loginId = :login";
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Query query = session.createQuery(statement);
			query.setParameter("login", login);
			List<Instructor> instructors = query.list();
			Instructor instructor = instructors.get(0);
			instructor.getCredentials().setHash(null);
			instructor.getPersonalInfo().toString();
			return instructor;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<InstructorCourse> getInstructorCourseInfo(String login) {
		String statement = "from InstructorCourse ic WHERE ic.instructor.credentials.loginId = :login";
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Query query = session.createQuery(statement);
			query.setParameter("login", login);
			List<InstructorCourse> courses = query.list();
			courses.toString();// TODO temp for lazy loading
			return courses;
		} finally {
			session.close();
		}
	}
}
