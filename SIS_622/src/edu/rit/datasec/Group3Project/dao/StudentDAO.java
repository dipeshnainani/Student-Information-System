package edu.rit.datasec.Group3Project.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.rit.datasec.Group3Project.bo.Student;
import edu.rit.datasec.Group3Project.bo.StudentCourse;
import edu.rit.datasec.Group3Project.hibernate.util.HibernateUtil;

public class StudentDAO {

	private static StudentDAO STUDENT_DAO;

	private StudentDAO() {

	}

	public static StudentDAO getInstance() {
		if (STUDENT_DAO == null) {
			STUDENT_DAO = new StudentDAO();
		}
		return STUDENT_DAO;
	}

	@SuppressWarnings("unchecked")
	public Student getStudentInfo(String login) {
		String statement = "from Student s WHERE s.credentials.loginId = :login";
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Query query = session.createQuery(statement);
			query.setParameter("login", login);
			List<Student> students = query.list();
			Student student = students.get(0);
			student.getCredentials().setHash(null);
			student.getPersonalInfo().toString();
			return student;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<StudentCourse> getStudentCourseInfo(String login) {
		String statement = "from StudentCourse sc WHERE sc.student.credentials.loginId= :login";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery(statement);
			query.setParameter("login", login);
			List<StudentCourse> courses = query.list();
			courses.toString(); // TODO temp for lazy loading
			return courses;
		} finally {
			session.close();
		}

	}
}
