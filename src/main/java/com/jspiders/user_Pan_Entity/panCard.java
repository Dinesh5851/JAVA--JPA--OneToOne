package com.jspiders.user_Pan_Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class panCard {
	
	@Id
	private int PanId;
	private String PanCardNumber;
	private String Name;
	private String DOB;
	private String Address;
	
	@OneToOne(mappedBy="Pancard")
	private User user;

	public int getPanId() {
		return PanId;
	}

	public void setPanId(int panId) {
		PanId = panId;
	}

	public String getPanCardNumber() {
		return PanCardNumber;
	}

	public void setPanCardNumber(String panCardNumber) {
		PanCardNumber = panCardNumber;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public User getUser() {
		return user;
	}

	public void addUser(User user) {
		this.user = user;
		user.addPancard(this);
	}
}
