package com.hubsport.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hubsport.domain.Users;

@Controller
public class AdminController {

	
	 @RequestMapping(value="/admin")
	 public ModelAndView showLogin() {
		 ModelAndView mav = new ModelAndView("admin/login");
		 mav.addObject("command", new Users());
		 return mav;
	 }
	 
	 
	 @RequestMapping(value="/login", method=RequestMethod.GET)
	 public ModelAndView loginTest() {
		 ModelAndView mav = new ModelAndView("admin/dashboard");
		 mav.addObject("command", new Users());
		 return mav;
	 }
}
