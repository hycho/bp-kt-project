package kr.co.kakaotheme.service.impl;

import java.util.List;

import kr.co.kakaotheme.domain.User;
import kr.co.kakaotheme.repository.UserRepository;
import kr.co.kakaotheme.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
