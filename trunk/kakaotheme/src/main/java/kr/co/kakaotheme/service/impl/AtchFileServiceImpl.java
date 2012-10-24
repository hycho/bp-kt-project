package kr.co.kakaotheme.service.impl;

import java.util.ArrayList;

import kr.co.kakaotheme.domain.AtchFile;
import kr.co.kakaotheme.repository.AtchFileRepository;
import kr.co.kakaotheme.service.AtchFileService;

import org.springframework.beans.factory.annotation.Autowired;

public class AtchFileServiceImpl implements AtchFileService {

	private AtchFileRepository atchfilerepository;
	
	@Autowired
	public void setFileRepository(AtchFileRepository atchfilerepository) {
		this.atchfilerepository = atchfilerepository;
	}
	
	@Override
	public void insert(AtchFile file) {
		atchfilerepository.save(file);
		
	}

	@Override
	public ArrayList<AtchFile> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AtchFile> select(AtchFile file) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
