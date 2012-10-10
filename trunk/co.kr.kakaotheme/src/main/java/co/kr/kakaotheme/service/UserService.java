package co.kr.kakaotheme.service;

import java.util.List;

import co.kr.kakaotheme.domain.User;

public interface UserService {
	public User getUserInfo(String userId, String userPassword);
	public List<User> findAllUsers();
	public void saveUser(User user);
}
