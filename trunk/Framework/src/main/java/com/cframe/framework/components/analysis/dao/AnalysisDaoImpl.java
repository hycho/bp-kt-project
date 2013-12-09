package com.cframe.framework.components.analysis.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cframe.framework.core.database.mybatis3.BaseSqlSessionDaoSupport;

@Repository("analysisDao")
public class AnalysisDaoImpl extends BaseSqlSessionDaoSupport{

	static final Logger log = LoggerFactory.getLogger(AnalysisDaoImpl.class);
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

  public List<Map<String, Object>> selectAnalysisSexForServiceMap(Map<String, Object> params){
  	StringBuffer sql = new StringBuffer();
  	sql.append("SELECT CASE SEX WHEN '0' THEN '남성' WHEN '1' THEN '여성' ELSE '기타' END AS SEXTYPE, COUNT(*) AS TOT FROM TB_SERVICE_ANS ");
  	sql.append("WHERE PSERVICE = ? ");
  	sql.append("AND PMETHOD = ?");
  	sql.append("GROUP BY SEX");
  	
	  
	  return jdbcTemplate.queryForList(sql.toString(), new Object[]{
		  "com.cframe.framework.components.user.web.UserManagerController",
		  "userListView"
	  	});
    }

}