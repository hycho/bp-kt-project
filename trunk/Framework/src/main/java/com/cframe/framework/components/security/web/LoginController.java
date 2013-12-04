package com.cframe.framework.components.security.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
  @RequestMapping(value = "/login")
	public String home() {
    return "components/login/login";
	}
  
  /**
	 * 유저 등록 화면으로 이동한다.
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/regist")
	public String userInsertView(HttpServletRequest request)throws Exception {
		return "components/userManager/insert";
  }
}