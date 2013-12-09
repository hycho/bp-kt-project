package com.cframe.framework.components.autor.model;



import java.io.Serializable;

public class Author implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 권한관리
	 */	
	private Author author;
	/**
	 * 권한코드
	 */
	private String authorCode;
	/**
	 * 권한등록일자
	 */
	private String creatDt;
	/**
	 * 권한코드설명
	 */
	private String authorDc;
	/**
	 * 권한 명
	 */
	private String authorNm;
	
	public Author getAuthor() {
		return author;
	}
	
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public String getAuthorCode() {
		return authorCode;
	}
	
	public void setAuthorCode(String authorCode) {
		this.authorCode = authorCode;
	}
	
	public String getCreatDt() {
		return creatDt;
	}
	
	public void setCreatDt(String creatDt) {
		this.creatDt = creatDt;
	}
	
	public String getAuthorDc() {
		return authorDc;
	}
	
	public void setAuthorDc(String authorDc) {
		this.authorDc = authorDc;
	}
	
	public String getAuthorNm() {
		return authorNm;
	}
	
	public void setAuthorNm(String authorNm) {
		this.authorNm = authorNm;
	}
}
