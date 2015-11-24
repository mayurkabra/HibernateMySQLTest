package com.hibernate.test.api;

import com.hibernate.test.pojo.Ride;

public interface RideDAOInterface {

	public void createRide(Ride newRide);
	public void editRide(Ride updatedRide);
	public void deleteRide(Ride rideToDelete);
	public Ride fetchRide(long rideId);
}
