package com.hibernate.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hibernate.test.api.RequestServiceInterface;
//import com.hibernate.test.api.RideServiceInterface;
import com.hibernate.test.pojo.Request;

@Controller
@RequestMapping(value="/reqmc")
public class RequestMultiactionController {
	
	@Autowired
	RequestServiceInterface requestServiceInterface;
	
	@RequestMapping(value="test", method = RequestMethod.GET)
	public ModelAndView test(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String name){
		ModelAndView modelAndView = new ModelAndView();
		Request newRequest = new Request();
		newRequest.setPickupPlace("PickPlace");
		newRequest.setDestinationPlace("DestPlace");
		
		requestServiceInterface.createRequest(newRequest);
		
		modelAndView.setViewName("test");
		return modelAndView;
	}

}
