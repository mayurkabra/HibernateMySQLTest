package com.hibernate.test.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.test.api.RideDAOInterface;
import com.hibernate.test.pojo.Request;
import com.hibernate.test.pojo.RequestRideMapping;
import com.hibernate.test.pojo.RequestRideStatus;
import com.hibernate.test.pojo.Ride;
import com.hibernate.test.pojo.User;

@Service
public class RideServiceImpl implements com.hibernate.test.api.RideServiceInterface {
	
	@Autowired
	RideDAOInterface rideDAO;

	public void createRide(Ride newRide) {
		rideDAO.createRide(newRide);	
	}

	public void editRide(Ride updatedRide) {
		rideDAO.editRide(updatedRide);	
	}

	public void deleteRide(long rideId) {
		//Ride rideToDelete = rideDAO.fetchRide(rideId);
		//if(rideToDelete != null){
			rideDAO.deleteRide(rideId);
		//}
	}

	public List<Ride> getUserRides(int userId) {
		return rideDAO.fetchUserRides(userId);	
	}
	
	public Ride fetchRide(long rideId) {
		return rideDAO.fetchRide(rideId);
	}
	
	public void addRequestToRide(Request request, Ride ride){
		RequestRideMapping mappingObj = new RequestRideMapping();
		mappingObj.setRequest(request);
		mappingObj.setRide(ride);
		mappingObj.setRequestRideStatus(RequestRideStatus.PENDING);
		rideDAO.addRequestToRide(mappingObj);
	}
}
