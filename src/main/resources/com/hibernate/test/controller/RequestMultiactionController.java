package com.hibernate.test.controller;

import java.util.Date;

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
import com.hibernate.test.pojo.User;

@Controller
@RequestMapping(value="/reqmc")
public class RequestMultiactionController {
	
	@Autowired
	RequestServiceInterface requestServiceInterface;
	
	@RequestMapping(value="test", method = RequestMethod.GET)
	public ModelAndView test(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String name){
		ModelAndView modelAndView = new ModelAndView();
		Request request = new Request();
		request.setDestination("TD");
		request.setPickupPlace("PP");
		request.setRequestTime(new Date());
		request.setStartTime(new Date());
		User requestedBy = new User();
		requestedBy.setUserId(1L);
		request.setRequestedBy(requestedBy);
		
		requestServiceInterface.createRequest(request);
		
		modelAndView.setViewName("test");
		return modelAndView;
	}
	
	@RequestMapping(value="fetchTest", method = RequestMethod.GET)
	public ModelAndView fetchTest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String name){
		ModelAndView modelAndView = new ModelAndView();
		
		requestServiceInterface.getAllRequests();
		
		modelAndView.setViewName("test");
		return modelAndView;
	}
	
	@RequestMapping(value="formNewRequest", method = RequestMethod.GET)
	public ModelAndView formNewRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("new_request");
		return modelAndView;
	}
	
	@RequestMapping(value="submitNewRequest")
	public ModelAndView newRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Request request){
		ModelAndView modelAndView = new ModelAndView();
		//Request request = new Request();
		request.setRequestTime(new Date());
		User requestedBy = new User();
		requestedBy.setUserId(1L);
		request.setRequestedBy(requestedBy);
		
		requestServiceInterface.createRequest(request);
		
		modelAndView.setViewName("test");
		return modelAndView;
	}

}
