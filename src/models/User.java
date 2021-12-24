package models;

public class User {

	private  String firstname; 
	private String lastname;
	private String cin; 
	private String phone;
	private String emailId; 
	private String passwordID; 
	private String entity;
	
	public User(String emailId, String passwordID) {
		super();
		this.emailId = emailId;
		this.passwordID = passwordID;
	}

	public User(String firstname, String lastname, String cin, String phone, String emailId, String passwordID,
			String entity) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.cin = cin;
		this.phone = phone;
		this.emailId = emailId;
		this.passwordID = passwordID;
		this.entity = entity;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPasswordID() {
		return passwordID;
	}

	public void setPasswordID(String passwordID) {
		this.passwordID = passwordID;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}
	
	
	
	
}
