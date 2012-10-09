package co.kr.kakaotheme.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TB_USER")
public class User {
	@Id
	@Column(name = "SID")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "USERID")
	private String userId;
	
	@Column(name = "USERPASSWORD")
	private String userPassword;
	
	@Column(name = "USERNAME")
	private String userName;
	
	@Column(name = "USEREMAIL")
	private String userEmail;

	public User() {
		super();
	}
	
	public User(String userId, String userPassword, String userName, String userEmail) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userEmail = userEmail;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
}
