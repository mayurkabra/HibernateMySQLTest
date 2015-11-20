package com.hibernate.test.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ride")
public class Ride {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long rideId;
	
	private String startPoint;
	private String destination;
	private boolean isPickupOtherThanStartProvided;
	private int maxNoOfPassengers;
	private Date StartTime;
	private Date ridePostedOn; 
	private float pricePerUser;
	private boolean isPriceNegotiable;
	private String comments;
	
	private User rideOwner;
	
	public Ride() {}


	public int getRideId() {
		return rideId;
	}


	public void setRideId(int rideId) {
		this.rideId = rideId;
	}


	public String getStartPoint() {
		return startPoint;
	}


	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public boolean isPickupOtherThanStartProvided() {
		return isPickupOtherThanStartProvided;
	}


	public void setPickupOtherThanStartProvided(boolean isPickupOtherThanStartProvided) {
		this.isPickupOtherThanStartProvided = isPickupOtherThanStartProvided;
	}


	public int getMaxNoOfPassengers() {
		return maxNoOfPassengers;
	}


	public void setMaxNoOfPassengers(int maxNoOfPassengers) {
		this.maxNoOfPassengers = maxNoOfPassengers;
	}


	public Date getStartTime() {
		return StartTime;
	}


	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}


	public Date getRidePostedOn() {
		return ridePostedOn;
	}


	public void setRidePostedOn(Date ridePostedOn) {
		this.ridePostedOn = ridePostedOn;
	}


	public float getPricePerUser() {
		return pricePerUser;
	}


	public void setPricePerUser(float pricePerUser) {
		this.pricePerUser = pricePerUser;
	}


	public boolean isPriceNegotiable() {
		return isPriceNegotiable;
	}


	public void setPriceNegotiable(boolean isPriceNegotiable) {
		this.isPriceNegotiable = isPriceNegotiable;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public User getRideOwner() {
		return rideOwner;
	}


	public void setRideOwner(User rideOwner) {
		this.rideOwner = rideOwner;
	}

	@Override
	public String toString() {
		return "Ride [rideId=" + rideId + ", startPoint=" + startPoint + ", destination=" + destination
				+ ", isPickupOtherThanStartProvided=" + isPickupOtherThanStartProvided + ", maxNoOfPassengers="
				+ maxNoOfPassengers + ", StartTime=" + StartTime + ", ridePostedOn=" + ridePostedOn + ", pricePerUser="
				+ pricePerUser + ", isPriceNegotiable=" + isPriceNegotiable + ", comments=" + comments + "]";
	};	
}
