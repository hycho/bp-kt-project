package co.kr.kakaotheme.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import co.kr.kakaotheme.domain.User;
import co.kr.kakaotheme.repository.UserRepository;
import co.kr.kakaotheme.service.UserService;

@Transactional
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User getUserInfo(String userId, String userPassword) {
		userRepository.findAll();
		return null;
	}
	
	public void saveUser(User user){
		userRepository.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAllUser();
	}
	
}
