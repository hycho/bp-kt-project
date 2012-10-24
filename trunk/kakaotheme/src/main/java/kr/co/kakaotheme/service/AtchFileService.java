package kr.co.kakaotheme.service;

import kr.co.kakaotheme.domain.AtchFile;

import org.springframework.data.domain.Page;

/**
 * 첨부 파일 서비스
 * @Class Name : AtchFileService.java
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
public interface AtchFileService {
	public void insert(AtchFile file);
	public Page<AtchFile> getAtchFileList(Integer pageNumber);
}
