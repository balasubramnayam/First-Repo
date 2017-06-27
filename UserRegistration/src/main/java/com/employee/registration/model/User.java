package com.employee.registration.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("user")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4197766986717628189L;

	@Id
	@Property("userId")
    private  int userId=getRandomNumberInRange();

	private String firstName;

	private String lastName;

	private Date birthDate;

	private String cityName;

	private Long pinCode;

	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Long getPinCode() {
		return pinCode;
	}

	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}

	public User() {
		super();
	}

	public User(String firstName, String lastName, Date birthDate, String cityName, Long pinCode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.cityName = cityName;
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate="
				+ birthDate + ", cityName=" + cityName + ", pinCode=" + pinCode + "]";
	}
	
	private static int getRandomNumberInRange() {
		Random r = new Random();
		return r.nextInt(10500070)+1;
	}
	
}
