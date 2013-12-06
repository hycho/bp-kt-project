package com.cframe.framework.components.analysis.service;

import java.util.List;
import java.util.Map;

/**
 * 일반회원관리에 관한 인터페이스클래스를 정의한다.
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
 *   2013.11.28  조호영.          최초 생성
 *
 * </pre>
 */
public interface AnalysisService {
	
	public List<Map<String, Object>> selectUser(Map<String, Object> params) throws Exception;
	
}