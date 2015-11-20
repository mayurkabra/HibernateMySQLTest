package com.hibernate.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@RequestMapping(value="login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
	{
		//get the login username and password
		//pass it to the Service and get the result
		//Send the acknowledgement through a ModelAndView
	}
	
}
