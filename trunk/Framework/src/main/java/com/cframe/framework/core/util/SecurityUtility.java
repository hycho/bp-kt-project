package com.cframe.framework.core.util;

import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;

import com.cframe.framework.core.security.userInfo.UserMapDetailsModel;

public class SecurityUtility {
	
	public static Map<String, Object> getLoginDetailMap(){
		Object principal =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	  if(principal instanceof UserMapDetailsModel){
		  UserMapDetailsModel data = (UserMapDetailsModel) principal;
			return (Map<String, Object>) data.getMapData();
		}else{
			return null;
		}
	}
	
}
