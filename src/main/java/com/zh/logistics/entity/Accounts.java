package com.zh.logistics.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 结算账户信息实体
 * @author zhanghao
 * 20150203
 */
@Entity
@Table(name = "accounts", catalog = "mylogistics")
public class Accounts implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String accountsCode;
	private String accountsName;
	private Double initialMoney;
	private Double currentMoney;
	private String memo;

	public Accounts() {
		System.out.println("创建了accounts实例");
	}

	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "accounts_code", unique = true, nullable = false, length = 15)
	public String getAccountsCode() {
		return this.accountsCode;
	}

	public void setAccountsCode(String accountsCode) {
		this.accountsCode = accountsCode;
	}

	@Column(name = "accounts_name", length = 15)
	public String getAccountsName() {
		return this.accountsName;
	}

	public void setAccountsName(String accountsName) {
		this.accountsName = accountsName;
	}

	@Column(name = "initial_money", precision = 10, scale = 9)
	public Double getInitialMoney() {
		return this.initialMoney;
	}

	public void setInitialMoney(Double initialMoney) {
		this.initialMoney = initialMoney;
	}

	@Column(name = "current_money", precision = 10, scale = 9)
	public Double getCurrentMoney() {
		return this.currentMoney;
	}

	public void setCurrentMoney(Double currentMoney) {
		this.currentMoney = currentMoney;
	}

	@Column(name = "memo", length = 200)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return String
				.format("Accounts [id=%s, accountsCode=%s, accountsName=%s, initialMoney=%s, currentMoney=%s, memo=%s]",
						id, accountsCode, accountsName, initialMoney,
						currentMoney, memo);
	}

}