package com.cframe.framework.components.autor.web;



import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cframe.framework.components.autor.service.AuthorService;
import com.cframe.framework.core.util.CommonUtility;





@Controller
@RequestMapping("/manager/author")
public class AuthorController {
	static final Logger log = LoggerFactory.getLogger(AuthorController.class);
	
	@Resource(name = "authorService")
    private AuthorService authorService;
	
	/**
	 * 권한 목록화면 이동
	 * @return String
	 * @exception Exception
	 */
    @RequestMapping(value="/AuthorListView", method = RequestMethod.GET)
    public @ResponseBody String selectAuthorListView()
            throws Exception {
        return "/AuthorListView";
    }    
    
    /**
	 * 권한 목록을 조회한다
	 * @param authorManageVO AuthorManageVO
	 * @return String
	 * @exception Exception
	 */
    @RequestMapping(value="/AuthorList")
    public @ResponseBody String selectAuthorList(HttpServletRequest request) throws Exception {
    	
    	/** EgovPropertyService.sample */
    	//authorManageVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	//authorManageVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** paging */
    	/*PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(authorManageVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(authorManageVO.getPageUnit());
		paginationInfo.setPageSize(authorManageVO.getPageSize());
		
		authorManageVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		authorManageVO.setLastIndex(paginationInfo.getLastRecordIndex());
		authorManageVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		authorManageVO.setAuthorManageList(egovAuthorManageService.selectAuthorList(authorManageVO));
        model.addAttribute("authorList", authorManageVO.getAuthorManageList());
        
        int totCnt = egovAuthorManageService.selectAuthorListTotCnt(authorManageVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        model.addAttribute("message", egovMessageSource.getMessage("success.common.select"));*/

        return "/AuthorList";
    } 
    
    /**
	 * 권한 세부정보를 조회한다.
	 * @param authorCode String
	 * @param authorManageVO AuthorManageVO
	 * @return String
	 * @exception Exception
	 */   
    @RequestMapping(value="/AuthorInfo")
    public @ResponseBody String selectAuthor(HttpServletRequest request) throws Exception {
    	
    	/*authorManageVO.setAuthorCode(authorCode);

    	model.addAttribute("authorManage", egovAuthorManageService.selectAuthor(authorManageVO));
    	model.addAttribute("message", egovMessageSource.getMessage("success.common.select"));*/
    	return "/AuthorInfo";
    }     

    /**
	 * 권한 등록화면 이동
	 * @return String
	 * @exception Exception
	 */     
    @RequestMapping("/AuthorInsertView")
    public String insertAuthorView()
            throws Exception {
        return "/components/author/regist";
    }
    
    /**
	 * 권한 세부정보를 등록한다.
	 * @param authorManage AuthorManage
	 * @param bindingResult BindingResult
	 * @return String
	 * @exception Exception
	 */ 
    @RequestMapping(value="/AuthorInsert", method = RequestMethod.GET)
    public @ResponseBody String insertAuthor(HttpServletRequest request) throws Exception {
    	Map<String, Object> params = CommonUtility.transDataMap(request);
    	authorService.insertAuthor(params);
    	return "/AuthorInsert";
    }
    
    /**
	 * 권한 세부정보를 수정한다.
	 * @param authorManage AuthorManage
	 * @param bindingResult BindingResult
	 * @return String
	 * @exception Exception
	 */   
    @RequestMapping(value="/AuthorUpdate")
    public @ResponseBody String updateAuthor(HttpServletRequest request) throws Exception {

    	/*beanValidator.validate(authorManage, bindingResult); //validation 수행
    	
		if (bindingResult.hasErrors()) {
			return "egovframework/com/sec/ram/EgovAuthorUpdate";
		} else {
	    	egovAuthorManageService.updateAuthor(authorManage);
	        status.setComplete();
	        model.addAttribute("message", egovMessageSource.getMessage("success.common.update"));
	        return "forward:/sec/ram/EgovAuthor.do";
		}*/
    	return "/AuthorUpdate";
    }    

    /**
	 * 권한 세부정보를 삭제한다.
	 * @param authorManage AuthorManage
	 * @return String
	 * @exception Exception
	 */  
    @RequestMapping(value="/AuthorDelete")
    public @ResponseBody String deleteAuthor(HttpServletRequest request) throws Exception {
    	
    	/*egovAuthorManageService.deleteAuthor(authorManage);
    	status.setComplete();
    	model.addAttribute("message", egovMessageSource.getMessage("success.common.delete"));*/
        return "/AuthorDelete";
    }   
    
    /**
	 * 권한목록을 삭제한다.
	 * @param authorCodes String
	 * @param authorManage AuthorManage
	 * @return String
	 * @exception Exception
	 */  
    @RequestMapping(value="/AuthorListDelete")
    public @ResponseBody String deleteAuthorList(HttpServletRequest request) throws Exception {

    	/*String [] strAuthorCodes = authorCodes.split(";");
    	for(int i=0; i<strAuthorCodes.length;i++) {
    		authorManage.setAuthorCode(strAuthorCodes[i]);
    		egovAuthorManageService.deleteAuthor(authorManage);
    	}
    	status.setComplete();
    	model.addAttribute("message", egovMessageSource.getMessage("success.common.delete"));*/
        return "/AuthorListDelete";
    }    
    
    /**
	 * 권한제한 화면 이동
	 * @return String
	 * @exception Exception
	 */
    @RequestMapping("/accessDenied")
    public @ResponseBody String accessDenied()
            throws Exception {
        return "/accessDenied";
    } 
        
    
    
    /*@RequestMapping(value="/ProgramListDetailSelect", method = RequestMethod.GET)
    public @ResponseBody ProgrmManageVO selectProgrm(
    		@RequestParam("tmp_progrmNm") String tmp_progrmNm ,
   		    @ModelAttribute("searchVO") ComDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
        
    	searchVO.setSearchKeyword(tmp_progrmNm);
    	ProgrmManageVO progrmManageVO = progrmManageService.selectProgrm(searchVO);
        
        return progrmManageVO;
    }
    
    @RequestMapping(value="/sample1", method = RequestMethod.GET)
    public @ResponseBody List<Map<String,Object>> sample1(
    		@ModelAttribute("progrmManageVO") ProgrmManageVO progrmManageVO){     
    	try {
			progrmManageService.deleteProgrm(progrmManageVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	List<Map<String,Object>> result = new ArrayList<Map<String,Object>>(); 
        
    	Map<String, Object> nMap = new HashMap<String, Object>();
    	nMap.put("CCC", "CCCC");
        result.add(nMap);
    	
        return result;
    }*/
}