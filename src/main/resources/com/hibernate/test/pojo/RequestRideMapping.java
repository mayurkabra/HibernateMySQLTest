package com.hibernate.test.pojo;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.test.util.HibernateUtil;

public class RequestRideMapping {

	private Request request;
	private Ride ride;
	
	public Request getRequests() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	public Ride getRide() {
		return ride;
	}
	public void setRide(Ride ride) {
		this.ride = ride;
	}
	
	

}
