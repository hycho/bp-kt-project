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

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.kakaotheme.service.ThemeService;
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

}
