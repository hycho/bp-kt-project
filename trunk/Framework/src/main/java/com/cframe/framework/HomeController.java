package com.cframe.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cframe.framework.core.security.userInfo.UserMapDetailsModel;

@Controller
public class HomeController {
	static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
  @RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
	  Object principal =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	  if(principal instanceof UserMapDetailsModel){
		  UserMapDetailsModel data = (UserMapDetailsModel) principal;
			System.out.println(data.getMapData());
		}else{
			log.info("Not Login");
		}
	  
	  
    return "/index";
	}
}