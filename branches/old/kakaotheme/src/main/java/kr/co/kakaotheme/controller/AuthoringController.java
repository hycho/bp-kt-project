package kr.co.kakaotheme.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 저작 컨트롤러
 * @Class Name : AuthoringController.java
 * @author 조호영 kofwhgh@gmail.com
 * @since 2012.10.12
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일                       수정자          수정내용
 *  ----------    ----    ---------------------------
 *  2012.10.12    조호영          최초 생성
 *
 * Copyright (C) 2012 by kakaotheme team  All right reserved.
 * </pre>
*/

@Controller
public class AuthoringController {
	private static final Logger logger = LoggerFactory.getLogger(AuthoringController.class);

	@RequestMapping(value = "/authoring")
	public String viewAuthroing(){
		return "authoring/authoring";
	}
	
	@RequestMapping(value = "/authoringlist")
	public String viewAuthoringList(){
		return "authoring/authoringList";
	}
}
