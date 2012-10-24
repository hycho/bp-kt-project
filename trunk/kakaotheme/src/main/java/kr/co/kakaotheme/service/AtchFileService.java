package kr.co.kakaotheme.service;

import kr.co.kakaotheme.domain.AtchFile;

public interface AtchFileService {
	public void insert(AtchFile file);
	public void selectAll();
	public void select(AtchFile file);
}
