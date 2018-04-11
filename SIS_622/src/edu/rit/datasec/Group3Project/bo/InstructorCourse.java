package edu.rit.datasec.Group3Project.bo;

import org.hibernate.envers.Audited;

@Audited
public class InstructorCourse {

	private int id;
	private int sectionNumber;
	private Instructor instructor;
	private Course course;
	private String classroom;
	private Integer startTime;
	private Integer length;
	private String meetingDays;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSectionNumber() {
		return sectionNumber;
	}

	public void setSectionNumber(int sectionNumber) {
		this.sectionNumber = sectionNumber;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public Integer getStartTime() {
		return startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getMeetingDays() {
		return meetingDays;
	}

	public void setMeetingDays(String meetingDays) {
		this.meetingDays = meetingDays;
	}

	@Override
	public String toString() {
		return "InstructorCourse [id=" + id + ", sectionNumber=" + sectionNumber + ", instructor=" + instructor
				+ ", course=" + course + ", classroom=" + classroom + ", startTime=" + startTime + ", length=" + length
				+ ", meetingDays=" + meetingDays + "]<br/>"; //TODO xss, this is bad! must be replaced
	}

}
