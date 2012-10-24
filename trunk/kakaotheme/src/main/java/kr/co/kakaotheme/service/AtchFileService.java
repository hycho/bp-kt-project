package kr.co.kakaotheme.service;

import java.util.ArrayList;

import kr.co.kakaotheme.domain.AtchFile;

public interface AtchFileService {
	public void insert(AtchFile file);
	public ArrayList<AtchFile> selectAll();
	public ArrayList<AtchFile> select(AtchFile file);
}
