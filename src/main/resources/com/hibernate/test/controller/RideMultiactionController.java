package com.hibernate.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hibernate.test.api.RideServiceInterface;
import com.hibernate.test.pojo.Ride;

@Controller
@RequestMapping(value="/rmc")
public class RideMultiactionController {
	
	@Autowired
	RideServiceInterface rideServiceInterface;
	
	@RequestMapping(value="createRide", method = RequestMethod.GET)
	public ModelAndView createRide(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Ride ride){
		ModelAndView modelAndView = new ModelAndView();
		Ride newRide = ride;
		System.out.println(newRide.getStartPoint());
		System.out.println(newRide.getMaxNoOfPassengers());
		//newRide.setStartPoint("Start");
		//newRide.setDestination("Last");
		
		rideServiceInterface.createRide(newRide);
		
		modelAndView.setViewName("test");
		return modelAndView;
	}
	
	@RequestMapping(value="editRide", method = RequestMethod.GET)
	public ModelAndView editRide(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Ride ride){
		ModelAndView modelAndView = new ModelAndView();
		Ride updatedRide = ride;
		//long rideId=1;//this data will be obtained from the request
		//Ride updatedRide = rideServiceInterface.fetchRide(rideId);
		/*if(updatedRide != null){
			updatedRide.setStartPoint("Start1");
			updatedRide.setDestination("Last1");*/
			
			rideServiceInterface.editRide(updatedRide);
		//}
		
		modelAndView.setViewName("test");
		return modelAndView;
	}
	
	@RequestMapping(value="deleteRide", method = RequestMethod.GET)
	public ModelAndView deleteRide(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, long rideId){
		ModelAndView modelAndView = new ModelAndView();
		//long rideId = 1;//This data will be obtained from request
		rideServiceInterface.deleteRide(rideId);
		
		modelAndView.setViewName("test");
		return modelAndView;
	}
	
	@RequestMapping(value="fetchUserRides", method = RequestMethod.GET)
	public ModelAndView fetchUserRides(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String name){
		ModelAndView modelAndView = new ModelAndView();
		long userId=1;//This data will be obtained from requests
		List<Ride> userRideList = rideServiceInterface.getUserRides(userId);
		
		modelAndView.setViewName("test");
		return modelAndView;
	}

	@RequestMapping(value="fetchRideDetails", method = RequestMethod.GET)
	public ModelAndView fetchRideDetails(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, long rideId){
		ModelAndView modelAndView = new ModelAndView();
		Ride ride = rideServiceInterface.fetchRide(rideId);
		System.out.println(ride.toString());
		modelAndView.setViewName("test");
		return modelAndView;
	}
}
