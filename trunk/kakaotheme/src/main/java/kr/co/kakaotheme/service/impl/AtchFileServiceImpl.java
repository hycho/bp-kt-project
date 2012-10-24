package kr.co.kakaotheme.service.impl;

import javax.inject.Inject;

import kr.co.kakaotheme.domain.AtchFile;
import kr.co.kakaotheme.repository.AtchFileRepository;
import kr.co.kakaotheme.service.AtchFileService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * 첨부 파일 서비스 구현 클래스
 * @Class Name : AtchFileServiceImpl.java
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
public class AtchFileServiceImpl implements AtchFileService {

	@Inject private AtchFileRepository atchfilerepository;

	private static final int PAGE_SIZE = 10;
	
	@Override
	public void insert(AtchFile file) {
		atchfilerepository.save(file);
	}
	
	@Override
	public Page<AtchFile> getAtchFileList(Integer pageNumber) {
        PageRequest pageRequest = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "startTime");
        return atchfilerepository.findAll(pageRequest);
    }

}
