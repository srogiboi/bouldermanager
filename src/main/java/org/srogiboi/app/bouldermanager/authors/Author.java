package org.srogiboi.app.bouldermanager.authors;

public class Author {

	private int id;
	private String firstName;
	private String lastName;
	int boulderCount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getBoulderCount() {
		return boulderCount;
	}

	public void setBoulderCount(int boulderCount) {
		this.boulderCount = boulderCount;
	}

}
