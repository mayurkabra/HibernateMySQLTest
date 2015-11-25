package com.hibernate.test.api;

import java.util.List;

import com.hibernate.test.pojo.RequestRideMapping;
import com.hibernate.test.pojo.Ride;

public interface RideDAOInterface {

	public void createRide(Ride newRide);
	public void editRide(Ride updatedRide);
	public void deleteRide(long rideId);
	public Ride fetchRide(long rideId);
	public List<Ride> fetchUserRides(int userId);
	public void addRequestToRide(RequestRideMapping mappingObj);
}
