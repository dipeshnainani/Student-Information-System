package edu.rit.datasec.Group3Project.bo;

import org.hibernate.envers.Audited;

@Audited
public class Department {
	
	private int id;
	private Instructor head;
	private String name;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Instructor getHead() {
		return head;
	}

	public void setHead(Instructor head) {
		this.head = head;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", head=" + head + ", name=" + name + "]<br/>"; //TODO xss, this is bad! must be replaced
	}
	
	
}
