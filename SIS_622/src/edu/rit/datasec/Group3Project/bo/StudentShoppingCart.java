package edu.rit.datasec.Group3Project.bo;

import org.hibernate.envers.Audited;

/**
 * @author hxk9860
 *
 */
@Audited
public class StudentShoppingCart {

	private int id;
	private Student student;
	private Course course;
	private Term term;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
