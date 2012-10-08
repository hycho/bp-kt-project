package co.kr.kakaotheme.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.kr.kakaotheme.domain.User;
import co.kr.kakaotheme.service.UserService;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(@RequestParam("userid") String userid, @RequestParam("userpassword") String userpassword, Model model) {
		User user = userService.getUserInfo(userid, userpassword);
		
		model.addAttribute("userid", user.getUserId());
		model.addAttribute("username", user.getUserName());
		model.addAttribute("useremail", user.getUserEmail());
		model.addAttribute("userinfo", user);
		
		return "sample/sample";
	}
}
