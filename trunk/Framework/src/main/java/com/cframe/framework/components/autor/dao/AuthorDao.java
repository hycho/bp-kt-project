package com.cframe.framework.components.autor.dao;





import java.util.List;
import java.util.Map;

public interface AuthorDao {
	/**
	 * 권한목록을 조회한다.
	 * @param authorManageVO AuthorManageVO
	 * @return List<AuthorManageVO>
	 * @exception Exception
	 */
	public List<Map<String, Object>> selectAuthorList(Map<String, Object> params) throws Exception;
	
	/**
	 * 권한을 등록한다.
	 * @param authorManage AuthorManage
	 * @exception Exception
	 */
    public void insertAuthor(Map<String, Object> params) throws Exception;

    /**
	 * 권한을 수정한다.
	 * @param authorManage AuthorManage
	 * @exception Exception
	 */
    public void updateAuthor(Map<String, Object> params) throws Exception;

    /**
	 * 권한을 삭제한다.
	 * @param authorManage AuthorManage
	 * @exception Exception
	 */
    public void deleteAuthor(Map<String, Object> params) throws Exception;

    /**
	 * 권한을 조회한다.
	 * @param authorManageVO AuthorManageVO
	 * @return AuthorManageVO
	 * @exception Exception
	 */
    public List<Map<String, Object>> selectAuthor(Map<String, Object> params) throws Exception;

    /**
	 * 권한목록 총 갯수를 조회한다.
	 * @param authorManageVO AuthorManageVO
	 * @return int
	 * @exception Exception
	 */
    public int selectAuthorListTotCnt(Map<String, Object> params)  throws Exception;
    
    /**
	 * 모든 권한목록을 조회한다.
	 * @param authorManageVO AuthorManageVO
	 * @return List<AuthorManageVO>
	 * @exception Exception
	 */
	public List<Map<String, Object>> selectAuthorAllList(Map<String, Object> params) throws Exception;
	
}
