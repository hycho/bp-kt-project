package kr.co.kakaotheme.repository;

import java.util.ArrayList;

import kr.co.kakaotheme.domain.AtchFile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AtchFileRepository extends JpaRepository<AtchFile, Long>{
	ArrayList<AtchFile> findAll();
	
}
