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
package egovframework.kakaotheme.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import egovframework.kakaotheme.service.ThemeService;
import egovframework.kakaotheme.util.constants.Constants;
import egovframework.kakaotheme.util.process.ProcessRun;

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

@Service("themeService")
public class ThemeServiceImpl implements ThemeService{
	
	@Resource(name="themeDao")
    private ThemeDao themeDao;
	
	@Value("#{config['Globals.AbsoluteWebPath']}") 
	private String absoluteWebPath;
	
	@Value("#{config['Globals.AndroidJarPath']}") 
	private String androidJarPath;
	
	@Value("#{config['Globals.DownLoadApkName']}") 
	private String downLoadApkName;
		
	public List getThemeList() throws Exception {
		List resultList = themeDao.selectThemeList();
		return resultList;
	}

	public List<Map<String, Object>> getRecommendThemeList(Map<String, Object> parameters) throws Exception {
		List<Map<String, Object>> resultList = themeDao.selectRecommendList(parameters);
		return resultList;
	}

	public Map<String, Object> getViewTheme(Map<String, Object> parameters)	throws Exception {
		Map<String, Object> result = themeDao.viewTheme(parameters);
		return result;
	}

	public void pakageTheme(Map<String, Object> parameters)
			throws Exception {
		
		String homePath = absoluteWebPath + Constants.FILE_SEPARATOR + (String) parameters.get("themeSeq");
		String andriodXmlPath = homePath + Constants.FILE_SEPARATOR + "AndroidManifest.xml";
		String resourcePath = homePath + Constants.FILE_SEPARATOR + "res";
		String pakagePath = homePath + Constants.FILE_SEPARATOR + "pakage.apk";
		
		String realPakagePath = homePath + Constants.FILE_SEPARATOR + downLoadApkName;
		String classDexPath = homePath + Constants.FILE_SEPARATOR + "bin" + Constants.FILE_SEPARATOR + "classes.dex";
		String srcPath = homePath + Constants.FILE_SEPARATOR + "src";
		
		String[] firstPakageCmdLine = new String[]	{
			"aapt.exe",
			"package",
			"-f",
			"-M",
			andriodXmlPath,
			"-S",
			resourcePath,
			"-I",
			androidJarPath,
			"-F",
			pakagePath
		};
		
		ProcessRun.run(firstPakageCmdLine);
		
		String[] secondPakageCmdLine = new String[]	{
			"apkbuilder.bat",
			realPakagePath,
			"-z",
			pakagePath,
			"-f",
			classDexPath,
			"-rf",
			srcPath
		};
		
		ProcessRun.run(secondPakageCmdLine);
	}

	public void importTheme(MultipartHttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
		Map<String, MultipartFile> files = request.getFileMap();
		CommonsMultipartFile cmf = (CommonsMultipartFile) files.get("importFile");
		
		//cmf.getInputStream();
		
	}
}
