package co.kr.kakaotheme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.kr.kakaotheme.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
	@Query("FROM User")
	List<User> findAllUser();
}
