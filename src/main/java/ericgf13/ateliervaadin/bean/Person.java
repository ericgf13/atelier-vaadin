package ericgf13.ateliervaadin.bean;

import java.time.LocalDate;

public class Person {

	private String name;
	private String country;
	private LocalDate birthDate;

	public Person() {
	}
	
	public Person(String name, String country, LocalDate birthDate) {
		this.name = name;
		this.country = country;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
}
