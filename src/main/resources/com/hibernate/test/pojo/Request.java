package com.hibernate.test.pojo;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="Request")
public class Request {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
	private String pickupPlace;
	private String destination;
	private Date startTime;
	private String comments;
	private Date requestPublished;
	private Integer requestedUserId;
	
	public Request() {};
	
	public Request(String pickupPlace, String destination, Date startTime, String comments, Date requestPublished, Integer requestedUserId)
	{
		this.pickupPlace = pickupPlace;
		this.destination = destination;
		this.startTime = startTime;
		this.comments = comments;
		this.requestPublished = requestPublished;
		this.requestedUserId = requestedUserId;
	}
	
	public Integer getId()
	{
		return Id;
	}
	public String getPickupPlace()
	{
		return pickupPlace;
	}
	public String getDestinationPlace()
	{
		return destinationPlace;
	}
	public Date getStartTime()
	{
		return startTime;
	}
	public String getComments()
	{
		return comments;
	}
	public Date getRequestPublished()
	{
		return requestPublished;
	}
	public Integer getRequestedUserId()
	{
		return requestedUserId;
	}
	
	
	public void setId(Integer Id)
	{
		this.Id = Id;
	}
	public void setPickupPlace(String pickupPlace)
	{
		this.pickupPlace = pickupPlace;
	}
	public void setDestinationPlace(String destination)
	{
		this.destination = destination;
	}
	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
	}
	public void setComments(String comments)
	{
		this.comments = comments;
	}
	public void setRequestPublished(Date requestPublished)
	{
		this.requestPublished = requestPublished;
	}
	public void setRequestedUserId(Integer requestedUserId)
	{
		this.requestedUserId = requestedUserId;
	}
}