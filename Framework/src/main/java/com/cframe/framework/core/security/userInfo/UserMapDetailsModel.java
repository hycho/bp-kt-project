package com.cframe.framework.core.security.userInfo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;



/**
 * User 클래스의 확장 클래스
 * 
 * @author ByungHun Woo
 * @since 2009.06.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    -------------    ----------------------
 *   2009.03.10  ByungHun Woo    최초 생성
 *
 * </pre>
 */

public class UserMapDetailsModel extends User {

	public UserMapDetailsModel(String username, String password,
			boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
	}

	public UserMapDetailsModel(String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	
	private Object mapData;	
	
	public UserMapDetailsModel(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Object mapData)
			throws IllegalArgumentException {

		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		
		this.mapData = mapData;
	}
	
	public UserMapDetailsModel(String username, String password, boolean enabled, Collection<? extends GrantedAuthority> authorities, Object mapData) throws IllegalArgumentException {
	  this(username, password, enabled, true, true, true, authorities, mapData);
	}
	
	public Object getMapData() {
		return mapData;
	}
	
	public void setMapData(Object mapData) {
		this.mapData = mapData;
	}
}
