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

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.sample.service.SampleDefaultVO;
import egovframework.rte.sample.service.SampleVO;


/**  
 * @Class Name : SampleDAO.java
 * @Description : Sample DAO Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2013.04.02    hycho       최초생성
 * 
 * @author hycho
 * @since 2013. 04.02
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */

@Repository("themeDao")
public class ThemeDao extends EgovAbstractDAO {

    public List selectThemeList() throws Exception {
        return getSqlMapClientTemplate().queryForList("themeDAO.selectAllTheme");
    }

    public List<Map<String, Object>> selectRecommendList(Map<String, Object> parameters) throws Exception {
        return getSqlMapClientTemplate().queryForList("themeDAO.selectBestCntTheme", parameters);
    }
    
    public Map<String, Object> viewTheme(Map<String, Object> parameters) throws Exception {
        return (Map<String, Object>) getSqlMapClientTemplate().queryForObject("themeDAO.viewTheme", parameters);
    }
    
}
