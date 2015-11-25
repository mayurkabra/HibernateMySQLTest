package com.hibernate.test.controller;

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
	
	@RequestMapping(value="test", method = RequestMethod.GET)
	public ModelAndView test(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String name){
		ModelAndView modelAndView = new ModelAndView();
		Ride newRide = new Ride();
		newRide.setStartPoint("Start");
		newRide.setDestination("Last");
		
		rideServiceInterface.createRide(newRide);
		
		modelAndView.setViewName("test");
		return modelAndView;
	}

}
