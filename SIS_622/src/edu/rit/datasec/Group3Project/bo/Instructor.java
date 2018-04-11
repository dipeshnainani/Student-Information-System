package edu.rit.datasec.Group3Project.bo;

import org.hibernate.envers.Audited;

@Audited
public class Instructor {

	private int uid;
	private Credentials credentials;
	private PersonalInfo personalInfo;
	private String firstName;
	private String middleName;
	private String lastName;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Instructor [uid=" + uid + ", credentials=" + credentials + ", personalInfo=" + personalInfo
				+ ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + "]<br/>"; //TODO xss, this is bad! must be replaced
	}
	
	

}
