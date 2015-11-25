package com.hibernate.test.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.test.api.RideDAOInterface;
import com.hibernate.test.pojo.Request;
import com.hibernate.test.pojo.Ride;
import com.hibernate.test.pojo.User;

@Service
public class RideServiceImpl implements com.hibernate.test.api.RideServiceInterface {
	
	@Autowired
	RideDAOInterface rideDAO;

	@Override
	public void createRide(Ride newRide) {
		rideDAO.createRide(newRide);
		
		
	}

	@Override
	public void editRide(User newUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelRide(long rideId) {
		// TODO Auto-generated method stub
		
	}

}
