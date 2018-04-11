package edu.rit.datasec.Group3Project.bo;

import java.util.Date;

import org.hibernate.envers.Audited;


@Audited
public class Enrollment {
	
	private int id;

	private Student student;
	private Date appointmentDate;
	private Term term;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	
	

}
