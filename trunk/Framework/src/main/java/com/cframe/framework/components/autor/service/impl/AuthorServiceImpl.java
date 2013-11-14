package com.cframe.framework.components.autor.service.impl;



import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cframe.framework.components.autor.dao.impl.AuthorDaoImpl;
import com.cframe.framework.components.autor.service.AuthorService;



@Service("authorService")
@Transactional(propagation=Propagation.REQUIRED)
public class AuthorServiceImpl implements AuthorService {
    
	@Resource(name="authorDao")
    private AuthorDaoImpl authorDao;

    /**
	 * 권한 목록을 조회한다.
	 * @param authorManageVO AuthorManageVO
	 * @return List<AuthorManageVO>
	 * @exception Exception
	 */
    public List<Map<String, Object>> selectAuthorList(Map<String, Object> params) throws Exception {
        return authorDao.selectAuthorList(params);
    }
    
	/**
	 * 권한을 등록한다.
	 * @param Map<String, Object> params
	 * @exception Exception
	 */
    @Transactional(rollbackFor=RuntimeException.class)
    public void insertAuthor(Map<String, Object> params) throws Exception {
    	authorDao.insertAuthor(params);
    	//throw new Exception();
    }

    /**
	 * 권한을 수정한다.
	 * @param Map<String, Object> params
	 * @exception Exception
	 */
    public void updateAuthor(Map<String, Object> params) throws Exception {
    	authorDao.updateAuthor(params);
    }

    /**
	 * 권한을 삭제한다.
	 * @param Map<String, Object> params
	 * @exception Exception
	 */
    public void deleteAuthor(Map<String, Object> params) throws Exception {
    	authorDao.deleteAuthor(params);
    }

    /**
	 * 권한을 조회한다.
	 * @param authorManageVO AuthorManageVO
	 * @return AuthorManageVO
	 * @exception Exception
	 */
    public List<Map<String, Object>> selectAuthor(Map<String, Object> params) throws Exception {
        return authorDao.selectAuthor(params);
    }

    /**
	 * 권한 목록 카운트를 조회한다.
	 * @param authorManageVO AuthorManageVO
	 * @return int
	 * @exception Exception
	 */
    public int selectAuthorListTotCnt(Map<String, Object> params) throws Exception {
        return authorDao.selectAuthorListTotCnt(params);
    }    
    
    /**
	 * 모든 권한목록을 조회한다.
	 * @param authorManageVO AuthorManageVO
	 * @return List<AuthorManageVO>
	 * @exception Exception
	 */
	public List<Map<String, Object>> selectAuthorAllList(Map<String, Object> params) throws Exception {
    	return authorDao.selectAuthorAllList(params);
    }      
}
