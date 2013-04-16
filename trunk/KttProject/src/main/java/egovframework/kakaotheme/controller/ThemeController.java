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
package egovframework.kakaotheme.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.kakaotheme.service.ThemeService;
import egovframework.kakaotheme.util.transform.RequestParamDataTrans;
import egovframework.rte.fdl.property.EgovPropertyService;

/**
 * @Class Name : PageController.java
 * @Description : Main Controller Class
 * @Modification Information @ 
 * @author kakaotalk theme editor 실행 환경 구성
 * @since 2013. 03.27
 * @version 1.0
 * @see Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class ThemeController {

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
	
	@Resource(name = "themeService")
	protected ThemeService themeService;
	
	protected static final Log log = LogFactory.getLog(ThemeController.class);
	
	/**
	 * 저작 페이지를 보여준다.
	 * jsonData를 리턴한다.
	 * @param model
	 * @return "/kakaotheme/main"
	 * @exception Exception
	 */
	@RequestMapping(value = "/theme/themeListAjax.do", method = RequestMethod.POST)
	@ResponseBody
	public String themePage() throws Exception {
		List themeAllList = themeService.getThemeList();
		return "test";
	}
	
	/**
	 * 저작 페이지를 보여준다.
	 * jsonData를 리턴한다.
	 * @param model
	 * @return "/kakaotheme/main"
	 * @exception Exception
	 */
	@RequestMapping(value = "/theme/recommendThemeListAjax.do", method = RequestMethod.POST)
	@ResponseBody
	public String recommendThemeListAjax(HttpServletRequest request) throws Exception {
		
		Map<String, Object> parameters = RequestParamDataTrans.transDataMap(request);
		
		List<Map<String, Object>> resultList = themeService.getRecommendThemeList(parameters);
		
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray(resultList);
		jsonObject.put("data", jsonArray);
		
		return jsonObject.toString();
	}
	
	/**
	 * 테마의 상세 페이지를 보여줍니다.
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/theme/viewTheme.do", method = RequestMethod.POST)
	public String viewTheme(HttpServletRequest request, ModelMap model) throws Exception {
		
		Map<String, Object> parameters = RequestParamDataTrans.transDataMap(request);
		
		Map<String, Object> resultMap = themeService.getViewTheme(parameters);
		
		model.addAttribute("result", resultMap);
		
		return "/kakaotheme/theme/view";
	}
	
	@RequestMapping(value = "/theme/runPackageDownAjax.do", method = RequestMethod.POST)
	@ResponseBody
	public String runPackageDownAjax(HttpServletRequest request) throws Exception {
		
		Map<String, Object> parameters = RequestParamDataTrans.transDataMap(request);
		
		themeService.pakageTheme(parameters);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", "success");
		
		return jsonObject.toString();
	}

}
