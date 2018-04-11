package edu.rit.datasec.Group3Project.bo;

import java.util.Date;

import org.hibernate.envers.Audited;

@Audited
public class Term {

	private int id;
	private String info;
	private Date startDate;
	private Date endDate;
	private String name;
	private Integer year;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Term [id=" + id + ", info=" + info + ", startDate=" + startDate + ", endDate=" + endDate + ", name="
				+ name + ", year=" + year + "]<br/>"; //TODO xss, this is bad! must be replaced
	}

}
