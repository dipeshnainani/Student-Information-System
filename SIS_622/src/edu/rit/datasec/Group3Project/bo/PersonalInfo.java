package edu.rit.datasec.Group3Project.bo;

import org.hibernate.envers.Audited;

@Audited
public class PersonalInfo {

	private int id;
	private String contactEmail;
	private String univEmail;
	private String contactNumber;
	private String emergencyContactEmail;
	private String emegencyContactNumber;
	private Address emergencyAddress;
	private Address primaryAddress;
	private Address currentAddress;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getUnivEmail() {
		return univEmail;
	}
	public void setUnivEmail(String univEmail) {
		this.univEmail = univEmail;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmergencyContactEmail() {
		return emergencyContactEmail;
	}
	public void setEmergencyContactEmail(String emergencyContactEmail) {
		this.emergencyContactEmail = emergencyContactEmail;
	}
	public String getEmegencyContactNumber() {
		return emegencyContactNumber;
	}
	public void setEmegencyContactNumber(String emegencyContactNumber) {
		this.emegencyContactNumber = emegencyContactNumber;
	}
	public Address getEmergencyAddress() {
		return emergencyAddress;
	}
	public void setEmergencyAddress(Address emergencyAddress) {
		this.emergencyAddress = emergencyAddress;
	}
	public Address getPrimaryAddress() {
		return primaryAddress;
	}
	public void setPrimaryAddress(Address primaryAddress) {
		this.primaryAddress = primaryAddress;
	}
	public Address getCurrentAddress() {
		return currentAddress;
	}
	public void setCurrentAddress(Address currentAddress) {
		this.currentAddress = currentAddress;
	}
	@Override
	public String toString() {
		return "PersonalInfo [id=" + id + ", contactEmail=" + contactEmail + ", univEmail=" + univEmail
				+ ", contactNumber=" + contactNumber + ", emergencyContactEmail=" + emergencyContactEmail
				+ ", emegencyContactNumber=" + emegencyContactNumber + ", emergencyAddress=" + emergencyAddress
				+ ", primaryAddress=" + primaryAddress + ", currentAddress=" + currentAddress + "]<br/>"; //TODO xss, this is bad! must be replaced
	}
	
	
	
	

}
