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

  public List<Map<String, Object>> selectAnalysisSexForServiceList(Map<String, Object> params){
  	StringBuffer sql = new StringBuffer();
  	sql.append("SELECT CASE SEX WHEN '0' THEN '남성' WHEN '1' THEN '여성' ELSE '기타' END AS SEXTYPE, COUNT(*) AS TOT FROM TB_SERVICE_ANS ");
  	sql.append("WHERE PSERVICE = ? ");
  	sql.append("AND PMETHOD = ?");
  	sql.append("GROUP BY SEX");
  		System.out.println((String) params.get("spacakge"));
	  
	  return jdbcTemplate.queryForList(sql.toString(), new Object[]{
		  (String) params.get("spacakge"),
		  (String) params.get("smethod")
	  	});
    }
  
  public List<Map<String, Object>> selectAnalysisAgeForServiceList(Map<String, Object> params){
	  	StringBuffer sql = new StringBuffer();
	  	sql.append("SELECT SUBSTR(TO_CHAR(TO_NUMBER(SUBSTR(TO_CHAR(CURRENT_DATE()),1,4))-1984),1,1) AS BGT, COUNT(*) AS TOT FROM TB_SERVICE_ANS ");
	  	sql.append("WHERE PSERVICE = ? ");
	  	sql.append("AND PMETHOD = ? ");
	  	sql.append("GROUP BY BGT");
	  	
		  return jdbcTemplate.queryForList(sql.toString(), new Object[]{
			  (String) params.get("spacakge"),
			  (String) params.get("smethod")
		  	});
	}
  
  public List<Map<String, Object>> selectAnalysisTop5IdForServiceList(Map<String, Object> params){
	  	StringBuffer sql = new StringBuffer();
	  	sql.append("SELECT USERID, COUNT(*) AS TOT FROM TB_SERVICE_ANS ");
	  	sql.append("WHERE PSERVICE = ? ");
	  	sql.append("AND PMETHOD = ? ");
	  	sql.append("GROUP BY USERID ");
	  	sql.append("ORDER BY TOT DESC ");
	  	sql.append("LIMIT 5");
	  	
		  
		  return jdbcTemplate.queryForList(sql.toString(), new Object[]{
			  (String) params.get("spacakge"),
			  (String) params.get("smethod")
		  	});
	    }

  
  
}