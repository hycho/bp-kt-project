package kr.co.kakaotheme.domain;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 첨부 파일 테이블 클래스
 * @Class Name : AtchFile.java
 * @author 김세중 sejoung@gmail.com
 * @since 2012.10.12
 * @version 1.0
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2012.10.12  김세중          최초 생성
 *
 * Copyright (C) 2012 by kakaotheme team  All right reserved.
 * </pre>
 */

@Entity
@Table(name="TB_ATCHFILE")
public class AtchFile extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 5527525182726172008L;

	/**
     * 첨부파일 아이디
     */
	@Column(name = "ATCHFILEID", nullable = false)
    public String atchFileId;
    
	/**
     * 생성일자
     */
	@Column(name = "CREATE_DATE")
    public Date creatDt;
	/**
     * 수정일자
     */
	@Column(name = "UPDATE_DATE")
	public Date updateDt;
	/**
     * 파일확장자
     */
	@Column(name = "FILEEXT")
    public String fileExt;
    
	/**
     * 파일크기
     */
	@Column(name = "FILESIZE", nullable = false)
    public String fileSize;
   
    /**
     * 파일저장경로
     */
	@Column(name = "FILESTRECOURS", nullable = false)
    public String fileStreCours;
    
    /**
     * 원파일명
     */
	@Column(name = "ORIGNLFILENM", nullable = false)
    public String orignlFileNm;
    
    /**
     * 저장파일명
     */
	@Column(name = "STREFILENM", nullable = false)
    public String streFileNm;

	/**
     * atchFileId attribute를 리턴한다.
     * @return the atchFileId
	 */
	public String getAtchFileId() {
		return atchFileId;
	}

	/**
     * atchFileId attribute 값을 설정한다.
     * @param atchFileId
     *            the atchFileId to set
     */
	public void setAtchFileId(String atchFileId) {
		this.atchFileId = atchFileId;
	}

    /**
     * creatDt attribute를 리턴한다.
     * 
     * @return the creatDt
     */	
	public Date getCreatDt() {
		return creatDt;
	}
	
    /**
     * creatDt attribute 값을 설정한다.
     * 
     * @param creatDt
     *            the creatDt to set
     */
	public void setCreatDt(Date creatDt) {
		this.creatDt = creatDt;
	}
	
	/**
     * updateDt attribute를 리턴한다.
     * 
     * @return the updateDt
     */	
	public Date getUpdateDt() {
		return updateDt;
	}
	
	/**
     * updateDt attribute 값을 설정한다.
     * 
     * @param updateDt
     *            the updateDt to set
     */
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}
	
    /**
     * fileExt attribute를 리턴한다.
     * 
     * @return the fileExt
     */
	public String getFileExt() {
		return fileExt;
	}

    /**
     * fileExt attribute 값을 설정한다.
     * 
     * @param fileExt
     *            the fileExt to set
     */
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

    /**
     * fileSize attribute를 리턴한다.
     * 
     * @return the fileSize
     */
	public String getFileSize() {
		return fileSize;
	}

    /**
     * fileSize attribute 값을 설정한다.
     * 
     * @param fileSize
     *            the fileSize to set
     */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

    /**
     * fileStreCours attribute를 리턴한다.
     * 
     * @return the fileStreCours
     */
	public String getFileStreCours() {
		return fileStreCours;
	}

    /**
     * fileStreCours attribute 값을 설정한다.
     * 
     * @param fileStreCours
     *            the fileStreCours to set
     */
	public void setFileStreCours(String fileStreCours) {
		this.fileStreCours = fileStreCours;
	}

    /**
     * orignlFileNm attribute를 리턴한다.
     * 
     * @return the orignlFileNm
     */
	public String getOrignlFileNm() {
		return orignlFileNm;
	}

    /**
     * orignlFileNm attribute 값을 설정한다.
     * 
     * @param orignlFileNm
     *            the orignlFileNm to set
     */
	public void setOrignlFileNm(String orignlFileNm) {
		this.orignlFileNm = orignlFileNm;
	}

    /**
     * streFileNm attribute를 리턴한다.
     * 
     * @return the streFileNm
     */
	public String getStreFileNm() {
		return streFileNm;
	}

    /**
     * streFileNm attribute 값을 설정한다.
     * 
     * @param streFileNm
     *            the streFileNm to set
     */
	public void setStreFileNm(String streFileNm) {
		this.streFileNm = streFileNm;
	}
	
	/* 
	 * toString 함수 대체
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
		
}