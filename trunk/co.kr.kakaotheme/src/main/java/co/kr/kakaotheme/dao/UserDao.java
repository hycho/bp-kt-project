package co.kr.kakaotheme.dao;

import java.util.List;

import co.kr.kakaotheme.domain.User;

public interface UserDao {
	public void store(User user);
	public void delete(Long id);
	public User findById(Long id);
	public List<User> findAll();
}
