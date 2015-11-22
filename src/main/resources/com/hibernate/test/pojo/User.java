package com.hibernate.test.pojo;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
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
	
	public Integer getId()
	{
		return Id;
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
	
	
	public void setId(Integer Id)
	{
		this.Id = Id;
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
	
	public String toString()
	{
		return "Id - "+ this.getId()+ ", FirstName - " + this.getFirstName() +", LastName - " 
				+ this.getLastName() + ", EmailAddress - " + this.getEmailAddress(); 
	}
}