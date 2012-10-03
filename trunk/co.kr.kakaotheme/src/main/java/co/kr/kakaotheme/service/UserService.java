package co.kr.kakaotheme.service;

import co.kr.kakaotheme.domain.User;

public interface UserService {
	public User getUserInfo(String userId, String userPassword);
}
