package com.cframe.framework.components.user.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cframe.framework.components.user.dao.UserManageDaoImpl;
import com.cframe.framework.components.user.service.UserManageService;

/**
 * 일반회원관리에 관한비지니스클래스를 정의한다.
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
@Service("userManageService")
public class UserManageServiceImpl implements UserManageService {
	
	@Resource(name="userManageDao")
	private UserManageDaoImpl userManageDao;

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int insertUser(Map<String, Object> params) throws Exception {
		return userManageDao.insertUser(params);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public List<Map<String, Object>> selectUser(Map<String, Object> params)	throws Exception {
		return userManageDao.selectUser(params);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public List<Map<String, Object>> selectUserList(Map<String, Object> params)	throws Exception {
		return userManageDao.selectUserList(params);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int selectUserListTotCnt(Map<String, Object> params) throws Exception {
		return userManageDao.selectUserListTotCnt(params);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int updateUser(Map<String, Object> params) throws Exception {
		return userManageDao.updateUser(params);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int deleteUser(Map<String, Object> params) throws Exception {
		return userManageDao.deleteUser(params);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int updatePassword(Map<String, Object> params) throws Exception {
		return userManageDao.updatePassword(params);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public List<Map<String, Object>> selectPassword(Map<String, Object> params)	throws Exception {
		return userManageDao.selectPassword(params);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int chkUserId(Map<String, Object> params) throws Exception {
		return userManageDao.chkUserId(params);
	}
	
}