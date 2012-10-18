package kr.co.kakaotheme.service.impl;

import kr.co.kakaotheme.domain.File;
import kr.co.kakaotheme.repository.FileRepository;
import kr.co.kakaotheme.service.FileService;

import org.springframework.beans.factory.annotation.Autowired;

public class FileServiceImpl implements FileService {

	private FileRepository filerepository;
	
	@Autowired
	public void setUserRepository(FileRepository filerepository) {
		this.filerepository = filerepository;
	}
	
	@Override
	public void insert(File file) {
		filerepository.save(file);
	}

}
