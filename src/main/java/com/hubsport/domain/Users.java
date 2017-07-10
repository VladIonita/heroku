package com.hubsport.domain;


public class Users {

	private int id;
	private int status;
	private String email;
	private String password;
	private String firstName;
	private String lastName;

	public Users() {
	}
	public Users(String email) {
		this.email = email;
	}

	public Users(int status, String email, String password, String firstName, String lastName) {
		this.status = status;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "Users [id=" + id + ", status=" + status + ", email=" + email + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}

}
