package com.zh.logistics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "mylogistics")
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String userCode;
	private String userName;
	private String password;
	private String address;
	private String tel;
	private Integer roleId;
	private String memo;

	// Constructors

	/** default constructor */ 
	public User() {
		
	}

	/** minimal constructor */
	public User(String userCode) {
		this.userCode = userCode;
	}

	/** full constructor */
	public User(String userCode, String userName, String address, String tel,
			Integer roleId, String memo) {
		this.userCode = userCode;
		this.userName = userName;
		this.address = address;
		this.tel = tel;
		this.roleId = roleId;
		this.memo = memo;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "user_code", nullable = false, length = 15)
	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@Column(name = "user_name", length = 24)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "address", length = 64)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "tel", length = 15)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "role_id")
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "memo", length = 200)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "password", length = 64)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}