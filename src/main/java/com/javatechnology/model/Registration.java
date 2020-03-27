package com.javatechnology.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.javatechnology.config.ValidEmail;

public class Registration {
	/*@AssertFalse
	@DecimalMax
	@Min
	@@Max*/
	private long id;
	@NotEmpty(message="first name is required")
	private String firstname;
	@NotEmpty(message="lastName is required")
	private String lastname;
	/*@Email(message="email is required")*/
	@ValidEmail
	private String email;
	private String phonenumber;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	

}
