package com.cframe.framework.components.analysis.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/analysis")
public class AnalysisController {
	static final Logger log = LoggerFactory.getLogger(AnalysisController.class);

	@RequestMapping(value="/clientAnalysisView")
	public String clientAnalysisView(HttpServletRequest request)throws Exception {
		return "components/analysis/clientAnalysisView";
	}
}