package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="signup")
public class PersonData {
	@Id
	@GeneratedValue
	private int id;
    @Column(name="firstName")
	private String firstName;
    @Column(name="lastName")
	private String lastName;
    
    

	public PersonData(int id, String firstName, String lastName) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
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

}