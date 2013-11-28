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
	 * 검색조건에 따른 유저들의 정보를 List로 받아온다. (현재 Json 형태로만 가능)
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectUserList")
	public @ResponseBody List<Map<String, Object>> selectUserList(HttpServletRequest request)throws Exception {
		Map<String, Object> params = CommonUtility.transDataMap(request);
		return userManageService.selectUserList(params);
    } 
  
	/**
	 * 유저를 저장한다.
	 * @param request
	 * @return 성공 1 실패 0
	 * @throws Exception
	 */
	@RequestMapping("/userInsert")
	public @ResponseBody int insertUser(HttpServletRequest request)throws Exception {
		Map<String, Object> params = CommonUtility.transDataMap(request);
		return userManageService.insertUser(params);
    }
   
	/**
	 * 검색조건에 따른 유저의 정보를 List로 받아온다. (현재 Json 형태로만 가능)
	 * @param request
	 * @return
	 * @throws Exception
	 */
  @RequestMapping("/userInfo")
  public @ResponseBody List<Map<String, Object>> userInfo(HttpServletRequest request)throws Exception {
	  Map<String, Object> params = CommonUtility.transDataMap(request);
    return userManageService.selectUser(params);
    }
    
  	/**
  	 * 유저의 정보를 수정한다.
  	 * @param request
  	 * @return
  	 * @throws Exception
  	 */
  @RequestMapping("/userUpdate")
	public @ResponseBody int updateMber(HttpServletRequest request)throws Exception {
		Map<String, Object> params = CommonUtility.transDataMap(request);
		return userManageService.updateUser(params);
    }
  
  	/**
  	 * 검색조건에 따른 유저를 삭제한다.
  	 * @param request
  	 * @return
  	 * @throws Exception
  	 */
	@RequestMapping("/userDelete")
	public @ResponseBody int deleteUser(HttpServletRequest request)throws Exception {
		Map<String, Object> params = CommonUtility.transDataMap(request);
		return userManageService.deleteUser(params);
    }
    
	/**
	 * 유저의 Password를 수정한다.
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/passwordUpdate")
	public @ResponseBody int updatePassword(HttpServletRequest request) throws Exception {
		Map<String, Object> params = CommonUtility.transDataMap(request);
		return userManageService.updatePassword(params);
    }
	
	/**
	 * 유저의 password를 가져온다.
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectPassword")
	public @ResponseBody List<Map<String, Object>> selectPassword(HttpServletRequest request) throws Exception {
		Map<String, Object> params = CommonUtility.transDataMap(request);
		return userManageService.selectPassword(params);
    }
	
	/**
	 * 중복된 UserID가 존재하는지 확인한다.
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/chkUserId")
	public @ResponseBody int chkUserId(HttpServletRequest request) throws Exception {
		Map<String, Object> params = CommonUtility.transDataMap(request);
		return userManageService.chkUserId(params);
    }
	
	@RequestMapping(value="/userListView")
	public String userListView(HttpServletRequest request)throws Exception {
		return "components/userManager/list";
    }
	
	@RequestMapping(value="/userUpdateView")
	public String userUpdateView(HttpServletRequest request)throws Exception {
		return "components/userManager/update";
    } 
	
	@RequestMapping(value="/userInsertView")
	public String userInsertView(HttpServletRequest request)throws Exception {
		return "components/userManager/insert";
    }
	
	@RequestMapping(value="/userPasswordUpdateView")
	public String userPasswordUpdateView(HttpServletRequest request)throws Exception {
		return "components/userManager/passwordUpdate";
    }
        
}