package org.srogiboi.app.bouldermanager.ascents;

import java.util.Date;

public class Ascent {
	
	int id;
	int userId;
	Date dateOfSent;
	int boulderId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getDateOfSent() {
		return dateOfSent;
	}
	public void setDateOfSent(Date dateOfSent) {
		this.dateOfSent = dateOfSent;
	}
	public int getBoulderId() {
		return boulderId;
	}
	public void setBoulderId(int boulderId) {
		this.boulderId = boulderId;
	}
	
}
