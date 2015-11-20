package com.hibernate.test.api;

public interface RideServiceInterface {

	//This method will create a new ride in the system
	//@param Ride object with all user details
	public void createRide(Ride newRide);
	
	//This method allows you to edit information for an existing ride
	//@param Ride object with updated ride information
	public void editRide(User newUser);
	
	//This method allows you to delete a ride
	//@param identifier of the ride
	public void cancelRide(long rideId);
}
