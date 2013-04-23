/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.kakaotheme.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

/**  
 * @Class Name : ThemeService.java
 * @Description : ThemeService Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2013.04.02  hycho       최초생성
 * 
 * @author 조호영
 * @since 2013. 04.02
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */
public interface ThemeService {
	public List getThemeList() throws Exception;
	public List<Map<String, Object>> getRecommendThemeList(Map<String, Object> parameters) throws Exception;
	public Map<String, Object> getViewTheme(Map<String, Object> parameters) throws Exception;
	/**
	 * Theme를 패키징 하고 패키징된 테마를 배치하고 배치된 테마의 주소를 String으로 넘겨줍니다.
	 * @param parameters
	 * @throws Exception
	 */
	public void pakageTheme(Map<String, Object> parameters) throws Exception;
	
	/**
	 * zip으로 압축이 된 테마를 import 한다.
	 * @param parameters
	 * @throws Exception
	 */
	public void importTheme(MultipartHttpServletRequest request) throws Exception;
	
}
