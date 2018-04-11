package edu.rit.datasec.Group3Project.bo;

import org.hibernate.envers.Audited;

@Audited
public class Course {
	private int id;
	private int level;
	private String courseId;
	private String name;
	private int capacity;
	private int waitlistCapacity;
	private Department department;
	private Term term;
	private int credits;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getWaitlistCapacity() {
		return waitlistCapacity;
	}

	public void setWaitlistCapacity(int waitlistCapacity) {
		this.waitlistCapacity = waitlistCapacity;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", level=" + level + ", courseId=" + courseId + ", name=" + name + ", capacity="
				+ capacity + ", waitlistCapacity=" + waitlistCapacity + ", department=" + department + ", term=" + term
				+ ", credits=" + credits + "]<br/>"; //TODO xss, this is bad! must be replaced
	}
	
	

}
