package com.dgit.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.dgit.domain.ManagerVO;

import com.dgit.service.ManService;

@Controller
@RequestMapping("/user")
public class ManController {
	private static final Logger logger = LoggerFactory.getLogger(ManController.class);
	
	@Autowired
	ManService service;
	
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public void loginGet(){
		logger.info("login GET.................................");
		
		
		
	}// /user/login
	
	@RequestMapping(value="/loginPost", method= RequestMethod.POST)
	public void loginPost(Model model, ManagerVO vo) throws Exception{
		logger.info("login Post.................................");
		logger.info(vo.toString());
		
		vo = service.login(vo);		
		if(vo == null){
			return;
		}
	
		
		
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session){
		logger.info("logout ..........................");
		
		
		session.invalidate(); //session bye
		
		return "redirect:/";
	}
	
	
}

























