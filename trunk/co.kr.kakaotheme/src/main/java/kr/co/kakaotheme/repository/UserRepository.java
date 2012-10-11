package kr.co.kakaotheme.repository;

import java.util.List;

import kr.co.kakaotheme.domain.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
	@Query("FROM User")
	List<User> findAllUser();
}
