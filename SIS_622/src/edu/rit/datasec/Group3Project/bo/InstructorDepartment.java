package edu.rit.datasec.Group3Project.bo;

import java.util.Date;

import org.hibernate.envers.Audited;


@Audited
public class InstructorDepartment {
	
	private int id;

	private Department department;
	private Instructor instructor;
	private Date contractStartDate;
	private boolean tenureTrack;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Date getContractStartDate() {
		return contractStartDate;
	}

	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public boolean isTenureTrack() {
		return tenureTrack;
	}

	public void setTenureTrack(boolean tenureTrack) {
		this.tenureTrack = tenureTrack;
	}

}
