package kr.co.kakaotheme.repository;

import java.util.ArrayList;


import kr.co.kakaotheme.domain.AtchFile;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 첨부 파일 테이블 레파지토리 인터페이스
 * @Class Name : AtchFileRepository.java
 * @author 김세중 sejoung@gmail.com
 * @since 2012.10.24
 * @version 1.0
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2012.10.24  김세중          최초 생성
 *
 * Copyright (C) 2012 by kakaotheme team  All right reserved.
 * </pre>
 */
public interface AtchFileRepository extends JpaRepository<AtchFile, Long>{
	
	/**
	 * 첨부 파일 키로 첨부 파일을 찾는다.
	 * @param atchFileId
	 * @return ArrayList<AtchFile>
	 */
	ArrayList<AtchFile> findByAtchFileId(String atchFileId);
}
