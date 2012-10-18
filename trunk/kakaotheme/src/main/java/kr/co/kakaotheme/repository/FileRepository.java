package kr.co.kakaotheme.repository;

import kr.co.kakaotheme.domain.File;

import org.springframework.data.repository.CrudRepository;

public interface FileRepository extends CrudRepository<File, Long>{
	
}
