package kr.co.kakaotheme.repository;

import java.util.List;

import kr.co.kakaotheme.domain.AtchFile;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AtchFileRepository extends CrudRepository<AtchFile, Long>{

	@Query("FROM TB_ATCHFILE")
	List<AtchFile> findAllUser();
}
