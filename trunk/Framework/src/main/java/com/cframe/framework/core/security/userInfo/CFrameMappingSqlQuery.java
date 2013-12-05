package com.cframe.framework.core.security.userInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

public abstract class CFrameMappingSqlQuery  extends MappingSqlQuery {

	public CFrameMappingSqlQuery() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 사용자정보를 테이블에서 조회하여 사용자객체에 매핑한다.
	 * @param ds DataSource
	 * @param usersByUsernameQuery String
	 */
	public CFrameMappingSqlQuery(DataSource ds, String usersByUsernameQuery) {
		super(ds, usersByUsernameQuery);
    declareParameter(new SqlParameter(Types.VARCHAR));
    compile();
    }

	@Override
  protected abstract Object mapRow(ResultSet rs, int rownum) throws SQLException;
}
