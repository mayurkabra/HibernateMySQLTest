package com.hibernate.test.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="request_ride_mapping")
public class RequestRideMapping {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long rrmId;

	@ManyToOne
	@JoinColumn(name="request_id")
	private Request request;
	
	@ManyToOne
	@JoinColumn(name="ride_id")
	private Ride ride;
	
	@Column(name="request_ride_status")
	@Enumerated(EnumType.STRING)
	private RequestRideStatus requestRideStatus;
	
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
	public RequestRideStatus getRequestRideStatus() {
		return requestRideStatus;
	}
	public void setRequestRideStatus(RequestRideStatus requestRideStatus) {
		this.requestRideStatus = requestRideStatus;
	}
	public Request getRequest() {
		return request;
	}
	public long getRrmId() {
		return rrmId;
	}
	public void setRrmId(long rrmId) {
		this.rrmId = rrmId;
	}
	
	

}
