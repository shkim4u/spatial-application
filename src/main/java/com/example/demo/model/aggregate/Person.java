package com.example.demo.model.aggregate;

import javax.persistence.*;

@Entity
@Table(name = "PEOPLE")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "first_name")
	private String lastName;

	@Column(name = "last_name")
	private String firstName;

	public Person() {
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getId() { return id; }

	@Override
	public String toString() {
		return "firstName: " + firstName + ", lastName: " + lastName;
	}

}
