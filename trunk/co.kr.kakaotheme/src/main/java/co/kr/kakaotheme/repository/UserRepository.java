package co.kr.kakaotheme.repository;

import org.springframework.data.repository.CrudRepository;

import co.kr.kakaotheme.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
}
