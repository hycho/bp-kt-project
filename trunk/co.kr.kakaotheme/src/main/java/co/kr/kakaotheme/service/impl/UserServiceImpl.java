package co.kr.kakaotheme.service.impl;

import co.kr.kakaotheme.domain.User;
import co.kr.kakaotheme.service.UserService;

public class UserServiceImpl implements UserService{

	public User getUserInfo(String userId, String userPassword) {
		if(userId.equals("hycho") && userPassword.equals("hycho")){
			User user = new User("hycho", "조호영", "hycho", "hycho@hycho.com");
			return user;
		}
		return null;
	}
	
}
