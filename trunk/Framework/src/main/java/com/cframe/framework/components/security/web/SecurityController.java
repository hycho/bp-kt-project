package com.cframe.framework.components.security.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class SecurityController {
	static final Logger log = LoggerFactory.getLogger(SecurityController.class);
	
  @RequestMapping(value = "/loginView")
	public String home() {
    return "components/login/login";
	}
  
  /**
	 * 유저 등록 화면으로 이동한다.
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/registView")
	public String registUserView(HttpServletRequest request)throws Exception {
		return "components/login/regist";
	}
}