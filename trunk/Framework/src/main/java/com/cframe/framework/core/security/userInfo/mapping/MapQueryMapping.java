package com.cframe.framework.core.security.userInfo.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.cframe.framework.core.security.userInfo.CFrameMappingSqlQuery;
import com.cframe.framework.core.security.userInfo.UserMapDetailsModel;
import com.cframe.framework.core.util.CommonUtility;

public class MapQueryMapping extends CFrameMappingSqlQuery {
	
	public MapQueryMapping(DataSource ds, String usersByUsernameQuery) {
		super(ds, usersByUsernameQuery);
	}

	@Override
	protected Object mapRow(ResultSet rs, int rownum) throws SQLException {
		String userid = rs.getString("id");
		String password = rs.getString("password");
		boolean enabled = rs.getBoolean("enabled");
		
		Map<String, Object> mapData = new HashMap<String, Object>();
		try {
			mapData = CommonUtility.transMapToResultSet(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("HOLDER"));
  
		return new UserMapDetailsModel(userid, password, enabled, authorities, mapData);
	}
}
