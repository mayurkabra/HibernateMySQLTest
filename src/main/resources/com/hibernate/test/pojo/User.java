package com.hibernate.test.pojo;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import javax.persistence.Column;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="Username")
	private String username;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="EmailAddress")
	private String emailAddress;
	
	@Column(name="MobileNo")
	private String mobileNo;
	
	@OneToMany(mappedBy = "rideOwner")
	private List<Ride> ownedRides;
	
	public User() {};
	
	public User(String username, String password, String firstName, String lastName, String emailAddress, String mobileNo)
	{
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.mobileNo = mobileNo;
	}
	
	public Integer getUserId()
	{
		return userId;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String getEmailAddress()
	{
		return emailAddress;
	}
	public String getMobileNo()
	{
		return mobileNo;
	}
	
	
	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}
	public void setUserName(String username)
	{
		this.username = username;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}
	public void setMobileNo(String mobileNo)
	{
		this.mobileNo = mobileNo;
	}
	
	public List<Ride> getOwnedRides() {
		return ownedRides;
	}

	public void setOwnedRides(List<Ride> ownedRides) {
		this.ownedRides = ownedRides;
	}

	public String toString()
	{
		return "userId - "+ this.getUserId()+ ", FirstName - " + this.getFirstName() +", LastName - " 
				+ this.getLastName() + ", EmailAddress - " + this.getEmailAddress(); 
	}
}