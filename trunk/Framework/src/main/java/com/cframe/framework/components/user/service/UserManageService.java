package com.cframe.framework.components.user.service;

import java.util.List;
import java.util.Map;

/**
 * 일반회원관리에 관한 인터페이스클래스를 정의한다.
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
 *   2013.11.28  조호영.          최초 생성
 *
 * </pre>
 */
public interface UserManageService {
	
	/**
	 * 유저를 저장한다.
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public int insertUser(Map<String, Object> params) throws Exception;
	
	/**
	 * 검색조건에 따른 유저의 정보를 가져온다.
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectUser(Map<String, Object> params) throws Exception;
	
	/**
	 * 검색조건에 따른 유저의 리스트를 가져온다.
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectUserList(Map<String, Object> params) throws Exception;
	
	/**
	 *  검색조건에 따른 유저리스트의 카운트를 가져온다.
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public int selectUserListTotCnt(Map<String, Object> params) throws Exception;
	
	/**
	 * 유저의 정보를 수정한다.
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public int updateUser(Map<String, Object> params) throws Exception;
	
	/**
	 * 검색조건에 따라 유저를 삭제 한다.
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public int deleteUser(Map<String, Object> params) throws Exception;
	
	/**
	 * 유저의 패스워드를 변경한다.
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public int updatePassword(Map<String, Object> params) throws Exception;
	
	/**
	 * 유저의 패스워드 정보를 알아온다.
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectPassword(Map<String, Object> params) throws Exception;
	
	/**
	 * 중복된 유저의 ID가 있는지 확인 한다.
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public int chkUserId(Map<String, Object> params) throws Exception;

}