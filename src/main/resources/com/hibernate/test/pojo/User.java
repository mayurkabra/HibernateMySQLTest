package com.hibernate.test.pojo;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String emailAddress;
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
}