package edu.rit.datasec.Group3Project.bo;

import org.hibernate.envers.Audited;

@Audited
public class Address {

	private int id;
	private String line1;
	private String line2;
	private String line3;
	private String city;
	private String state;
	private String country;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getLine3() {
		return line3;
	}

	public void setLine3(String line3) {
		this.line3 = line3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", line1=" + line1 + ", line2=" + line2 + ", line3=" + line3 + ", city=" + city
				+ ", state=" + state + ", country=" + country + "]<br/>"; //TODO xss, this is bad! must be replaced
	}
	
	

}
