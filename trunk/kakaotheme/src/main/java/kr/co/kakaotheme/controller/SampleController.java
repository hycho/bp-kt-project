package kr.co.kakaotheme.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kakaotheme.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/i18n", method = RequestMethod.GET)
	public String viewI18n(HttpServletRequest request, HttpServletResponse response){
		return "i18n/i18n_sample";
	}
	
}
