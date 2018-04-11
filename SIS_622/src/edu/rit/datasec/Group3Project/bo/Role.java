package edu.rit.datasec.Group3Project.bo;

public enum Role {
	Student(1), Instructor(2);

	private Role(int role) {
		this.role = role;
	}

	int role;
}
