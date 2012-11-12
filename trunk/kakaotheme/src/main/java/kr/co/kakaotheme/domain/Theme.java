package kr.co.kakaotheme.domain;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 테마
 * @Class Name : Theme.java
 * @author 조호영 kofwhgh@gmail.com
 * @since 2012.11.01
 * @version 1.0
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2012.10.12  조호영          최초 생성
 *
 * Copyright (C) 2012 by kakaotheme team  All right reserved.
 * </pre>
 */

@Entity
@Table(name="TB_THEME")
public class Theme extends AbstractPersistable<Long> {

	private static final long serialVersionUID = -1247884819209098196L;

	@Column(name = "THEMEKEY", nullable = false)
    public String themeKey;
   
	@Column(name = "TITLE")
    public Date title;

	@Column(name = "DESCRIPTION")
	public Date description;
	
	@Column(name = "THUMBNAILURL")
    public String thumbnailUrl;
    
	@Column(name = "USEYN")
    public String useYn; 
   
	@Column(name = "CREATEDDATE")
	public String createdDate;
	
	@Column(name = "UPDATEDDATE")
	public String updatedDate;
	
	@Column(name = "CREATOR")
	public String creator;
			
	public String getThemeKey() {
		return themeKey;
	}

	public void setThemeKey(String themeKey) {
		this.themeKey = themeKey;
	}

	public Date getTitle() {
		return title;
	}

	public void setTitle(Date title) {
		this.title = title;
	}

	public Date getDescription() {
		return description;
	}

	public void setDescription(Date description) {
		this.description = description;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	/* 
	 * toString 함수 대체
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
		
}
