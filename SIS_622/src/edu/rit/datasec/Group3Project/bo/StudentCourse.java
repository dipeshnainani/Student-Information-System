package edu.rit.datasec.Group3Project.bo;

import org.hibernate.envers.Audited;

@Audited
public class StudentCourse {

	private int id;
	private Student student;
	private InstructorCourse instructorCourse;
	private String status;
	private int waitingListNumber;

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

	public InstructorCourse getInstructorCourse() {
		return instructorCourse;
	}

	public void setInstructorCourse(InstructorCourse instructorCourse) {
		this.instructorCourse = instructorCourse;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getWaitingListNumber() {
		return waitingListNumber;
	}

	public void setWaitingListNumber(int waitingListNumber) {
		this.waitingListNumber = waitingListNumber;
	}

	@Override
	public String toString() {
		return "StudentCourse [id=" + id + ", student=" + student + ", instructorCourse=" + instructorCourse
				+ ", status=" + status + ", waitingListNumber=" + waitingListNumber + "]<br/>"; //TODO xss, this is bad! must be replaced
	}
	
	

}
