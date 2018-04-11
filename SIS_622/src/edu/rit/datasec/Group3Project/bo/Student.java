package edu.rit.datasec.Group3Project.bo;

import java.util.Date;

import org.hibernate.envers.Audited;

@Audited
public class Student {

	private int uid;
	private Credentials credentials;
	private PersonalInfo personalInfo;
	private String firstName;
	private String lastName;
	private String middleName;
	private Date matriculatedOn;
	private Date graduationDate;
	private int graduationCredits;
	private int creditsEnrolled;
	private int creditsGained;
	private float gpa;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Date getMatriculatedOn() {
		return matriculatedOn;
	}

	public void setMatriculatedOn(Date matriculatedOn) {
		this.matriculatedOn = matriculatedOn;
	}

	public Date getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}

	public int getGraduationCredits() {
		return graduationCredits;
	}

	public void setGraduationCredits(int graduationCredits) {
		this.graduationCredits = graduationCredits;
	}

	public int getCreditsEnrolled() {
		return creditsEnrolled;
	}

	public void setCreditsEnrolled(int creditsEnrolled) {
		this.creditsEnrolled = creditsEnrolled;
	}

	public int getCreditsGained() {
		return creditsGained;
	}

	public void setCreditsGained(int creditsGained) {
		this.creditsGained = creditsGained;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	@Override
	public String toString() {
		return "Student [uid=" + uid + ", credentials=" + credentials + ", personalInfo=" + personalInfo
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName
				+ ", matriculatedOn=" + matriculatedOn + ", graduationDate=" + graduationDate + ", graduationCredits="
				+ graduationCredits + ", creditsEnrolled=" + creditsEnrolled + ", creditsGained=" + creditsGained
				+ ", gpa=" + gpa + "]<br/>"; //TODO xss, this is bad! must be replaced
	}
	
	

}
