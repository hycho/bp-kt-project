package com.cframe.framework.components.user.web;

import java.util.List;
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

/**
 * 일반회원관련 요청을  비지니스 클래스로 전달하고 처리된결과를  해당   웹 화면으로 전달하는  API를 정의 한다.
 * @author 조호영.
 * @since 2013.11.28
 * @version 0.1
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2013.11.28  조호영          최초 생성
 *
 * </pre>
 */

@Controller
@RequestMapping("/manager/user")
public class UserManagerController {

	static final Logger log = LoggerFactory.getLogger(UserManagerController.class);
  
	@Resource(name = "userManageService")
  private UserManageService userManageService;
    
	
	
	/**
	 * 유저 리스트 화면으로 이동한다.
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/userListView")
	public String userListView(HttpServletRequest request)throws Exception {
		return "components/userManager/list";
    }
	
	/**
	 * 유저 수정 화면으로 이동한다.
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/userUpdateView")
	public String userUpdateView(HttpServletRequest request)throws Exception {
		return "components/userManager/update";
    } 
	
	/**
	 * 유저 등록 화면으로 이동한다.
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/userInsertView")
	public String userInsertView(HttpServletRequest request)throws Exception {
		return "components/userManager/insert";
    }
	
	/**
	 * 유저 password 수정 화면으로 이동한다.
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/userPasswordUpdateView")
	public String userPasswordUpdateView(HttpServletRequest request)throws Exception {
		return "components/userManager/passwordUpdate";
    }
        
}