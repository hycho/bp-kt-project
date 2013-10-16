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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import egovframework.rte.sample.service.EgovSampleService;
import egovframework.rte.sample.service.SampleDefaultVO;
import egovframework.rte.sample.service.SampleVO;

/**
 * @Class Name : PageController.java
 * @Description : Main Controller Class
 * @Modification Information @ @ 수정일 수정자 수정내용 
 * ------------------------------- @ 2013.03.27 hycho 최초생성
 * @author kakaotalk theme editor 실행 환경 구성
 * @since 2013. 03.27
 * @version 1.0
 * @see Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class PageController {

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	/**
	 * 메인 페이지를 보여준다.
	 *  
	 * @param model
	 * @return "/kakaotheme/main"
	 * @exception Exception
	 */
	@RequestMapping(value = "/page/main.do")
	public String mainPage(ModelMap model) throws Exception {
		return "/kakaotheme/main";
	}
	
	/**
	 * 저작 페이지를 보여준다.
	 *  
	 * @param model
	 * @return "/kakaotheme/theme"
	 * @exception Exception
	 */
	@RequestMapping(value = "/page/theme.do")
	public String themePage(ModelMap model) throws Exception {
		return "/kakaotheme/theme";
	}
	
	/**
	 * about 페이지를 보여준다.
	 *  
	 * @param model
	 * @return "/kakaotheme/about"
	 * @exception Exception
	 */
	@RequestMapping(value = "/page/about.do")
	public String aboutPage(ModelMap model) throws Exception {
		return "/kakaotheme/about";
	}
	
}
