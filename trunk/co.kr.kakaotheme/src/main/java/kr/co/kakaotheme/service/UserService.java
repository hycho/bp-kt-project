package kr.co.kakaotheme.service;

import java.util.List;

import kr.co.kakaotheme.domain.User;

public interface UserService {
	public User getUserInfo(String userId, String userPassword);
	public List<User> findAllUsers();
	public void saveUser(User user);
}
