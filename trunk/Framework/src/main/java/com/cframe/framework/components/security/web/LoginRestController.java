package com.cframe.framework.components.security.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cframe.framework.components.user.service.UserManageService;
import com.cframe.framework.core.util.CommonUtility;

@Controller
@RequestMapping("/rest/login")
public class LoginRestController {
	static final Logger log = LoggerFactory.getLogger(LoginRestController.class);
	
	@Resource(name = "userManageService")
	private UserManageService userManageService;
	
	/**
	 * 유저를 저장한다.
	 * @param request
	 * @return 성공 1 실패 0
	 * @throws Exception
	 */
	@RequestMapping("/regist")
	public @ResponseBody int insertUser(HttpServletRequest request)throws Exception {
		Map<String, Object> params = CommonUtility.transDataMap(request);
		return userManageService.insertUser(params);
    }
}