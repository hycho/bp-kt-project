package com.cframe.framework.core.security.userInfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContextException;
import org.springframework.dao.DataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import com.cframe.framework.core.util.ObjectUtil;

public class CFrameJdbcUserDetailsManager extends JdbcUserDetailsManager {
	
    private CFrameMappingSqlQuery usersByUsernameMapping;
	
    private String mapClass;
    private RoleHierarchy roleHierarchy = null;
    
    /**
     * 사용자 테이블의 쿼리 조회 컬럼과 세션에서 사용할 사용자 VO와 메핑 할 클래스를 지정한다.
     * @param mapClass String
     */
    public void setMapClass(String mapClass) {
    	this.mapClass = mapClass;
    }
    
    /**
     * Role Hierarchy를 지원한다.
     * (org.springframework.security.userdetails.hierarchicalroles.RoleHierarchyImpl)
     * @param roleHierarchy RoleHierarchy
     */
    public void setRoleHierarchy(RoleHierarchy roleHierarchy) {
    	this.roleHierarchy = roleHierarchy;
    }
    
    /*
     * (non-Javadoc)
     * @see org.springframework.security.userdetails.jdbc.JdbcUserDetailsManager#initDao()
     */
    @Override
    protected void initDao() throws ApplicationContextException {
    	super.initDao();

    	try {
    		initMappingSqlQueries();
    	} catch (ClassNotFoundException e) {
    		logger.error("EgovJdbcUserDetailsManager.initDao.ClassNotFoundException : " + e.toString(), e);
    	} catch (NoSuchMethodException e) {
    		logger.error("EgovJdbcUserDetailsManager.initDao.NoSuchMethodException : " + e.toString(), e);
    	} catch (InstantiationException e) {
    		logger.error("EgovJdbcUserDetailsManager.initDao.InstantiationException : " + e.toString(), e);
    	} catch (IllegalAccessException e) {
    		logger.error("EgovJdbcUserDetailsManager.initDao.IllegalAccessException : " + e.toString(), e);
    	} catch (InvocationTargetException e) {
    		logger.error("EgovJdbcUserDetailsManager.initDao.InvocationTargetException : " + e.toString(), e);
    	} catch (Exception e) {
    		logger.error("EgovJdbcUserDetailsManager.initDao.Exception : " + e.toString(), e);
    	}

    }
    
	/**
	 * jdbc-user-service의 usersByUsernameQuery 사용자조회 쿼리와
	 * authoritiesByUsernameQuery 권한조회 쿼리를 이용하여 정보를 저장한다.
	 */
	private void initMappingSqlQueries()
		throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException, ClassNotFoundException, Exception {
		
		setUsersByUsernameQuery(getUsersByUsernameQuery());
		
		Class <?> clazz = ObjectUtil.loadClass(this.mapClass);
		Constructor <?> constructor = clazz.getConstructor(new Class []{DataSource.class, String.class});
		Object [] params = new Object []{getDataSource(), getUsersByUsernameQuery()};

		this.usersByUsernameMapping = (CFrameMappingSqlQuery) constructor.newInstance(params);
    }

	/**
	 * JdbcDaoImpl 클래스의 loadUsersByUsername 메소드 재정의
	 * 사용자명(또는 ID)로 EgovUserDetails의 정보를 조회하여 리스트 형식으로 저장한다.
	 */
	@Override
	protected List<UserDetails> loadUsersByUsername(String username) {
		return usersByUsernameMapping.execute(username);
    }

	/**
	 * JdbcDaoImpl 클래스의 loadUsersByUsername 메소드 재정의
	 * 사용자명(또는 ID)로 EgovUserDetails의 정보를 조회한다.
	 * @param username String
	 * @return EgovUserDetails
	 * @throws UsernameNotFoundException
	 * @throws DataAccessException
	 */
	@Override
	public UserMapDetailsModel loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		
        List<?> users = loadUsersByUsername(username);

        if (users.size() == 0) {
        	throw new AccessDeniedException("No Access User");
        		}

        Object obj = users.get(0);
        UserMapDetailsModel userDetails = (UserMapDetailsModel) obj;

        Set<GrantedAuthority> dbAuthsSet = new HashSet<GrantedAuthority>();

        dbAuthsSet.addAll(loadUserAuthorities(userDetails.getUsername()));
        
        List<GrantedAuthority> dbAuths = new ArrayList<GrantedAuthority>(dbAuthsSet);

        addCustomAuthorities(userDetails.getUsername(), dbAuths);

        if (dbAuths.size() == 0) {
        	throw new AccessDeniedException("No Access User");
				}
        	
        // RoleHierarchyImpl 에서 저장한 Role Hierarchy 정보가 저장된다.
        //Collection<? extends GrantedAuthority> authorities = roleHierarchy.getReachableGrantedAuthorities(dbAuths);
        
        // JdbcDaoImpl 클래스의 createUserDetails 메소드 재정의
        return new UserMapDetailsModel(userDetails.getUsername(), userDetails.getPassword(), userDetails.isEnabled(), 
                true, true, true, dbAuths, userDetails.getMapData());
    }

	/**
	 * 인증된 사용자 이름으로 사용자정보(EgovUserDetails)를 가져온다. 
	 * @return EgovUserDetails
	 * @throws UsernameNotFoundException
	 * @throws DataAccessException
	 */
	public UserMapDetailsModel getAuthenticatedUser() throws UsernameNotFoundException, DataAccessException {

		return loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }

}
