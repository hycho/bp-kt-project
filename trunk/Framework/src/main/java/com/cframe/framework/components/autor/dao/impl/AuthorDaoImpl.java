package com.cframe.framework.components.autor.dao.impl;



import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cframe.framework.core.database.mybatis3.BaseSqlSessionDaoSupport;




@Repository("authorDao")
public class AuthorDaoImpl extends BaseSqlSessionDaoSupport{

    /**
	 * 권한목록을 조회한다.
	 * @param authorManageVO AuthorManageVO
	 * @return List<AuthorManageVO>
	 * @exception Exception
	 */
	public List<Map<String, Object>> selectAuthorList(Map<String, Object> params) throws Exception {
        return getSqlSession().selectList("authorDao.selectAuthorList", params);
    }
	
	/**
	 * 권한을 등록한다.
	 * @param authorManage AuthorManage
	 * @exception Exception
	 */
    public void insertAuthor(Map<String, Object> params) throws Exception {
    	getSqlSession().insert("authorDao.insertAuthor", params);
    }

    /**
	 * 권한을 수정한다.
	 * @param authorManage AuthorManage
	 * @exception Exception
	 */
    public void updateAuthor(Map<String, Object> params) throws Exception {
    	getSqlSession().update("authorDao.updateAuthor", params);
    }

    /**
	 * 권한을 삭제한다.
	 * @param authorManage AuthorManage
	 * @exception Exception
	 */
    public void deleteAuthor(Map<String, Object> params) throws Exception {
    	getSqlSession().delete("authorDao.deleteAuthor", params);
    }

    /**
	 * 권한을 조회한다.
	 * @param authorManageVO AuthorManageVO
	 * @return AuthorManageVO
	 * @exception Exception
	 */
    public List<Map<String, Object>> selectAuthor(Map<String, Object> params) throws Exception {
        return getSqlSession().selectList("authorDao.selectAuthor", params);
    }

    /**
	 * 권한목록 총 갯수를 조회한다.
	 * @param authorManageVO AuthorManageVO
	 * @return int
	 * @exception Exception
	 */
    public int selectAuthorListTotCnt(Map<String, Object> params)  throws Exception {
        return (Integer)getSqlSession().selectOne("authorDao.selectAuthorListTotCnt", params);
    }
    
    /**
	 * 모든 권한목록을 조회한다.
	 * @param authorManageVO AuthorManageVO
	 * @return List<AuthorManageVO>
	 * @exception Exception
	 */
	public List<Map<String, Object>> selectAuthorAllList(Map<String, Object> params) throws Exception {
        return getSqlSession().selectList("authorDao.selectAuthorAllList", params);
    }    
}
