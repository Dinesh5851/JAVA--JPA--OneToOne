package com.jspiders.user_Pan_Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class User {
	
	@Id
	private int UserId;
	private String UserName;
	private String Email;
	private long Contact;
	private String PanCardNumber;
	
    @OneToOne
    private panCard Pancard;
    
	public int getUserId() {
		return UserId;
	}
	public void addUserId(int userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long getContact() {
		return Contact;
	}
	public void setContact(long contact) {
		Contact = contact;
	}
	public String getPanCardNumber() {
		return PanCardNumber;
	}
	public void setPanCardNumber(String panCardNumber) {
		PanCardNumber = panCardNumber;
	}
	public panCard getPancard() {
		return Pancard;
	}
	public void addPancard(panCard pancard) {
		Pancard = pancard;
	}	

}
