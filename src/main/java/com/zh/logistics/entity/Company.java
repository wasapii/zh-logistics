package com.zh.logistics.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.zh.logistics.util.BaseContext;

/**
 * 单位信息
 * @author zhanghao
 * 20150203
 */
@Entity
@Table(name = "company", catalog = "mylogistics")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String companyCode;
	private Integer companyCategory;
	private String companyName;
	private String tel;
	private String address;
	private String zipCode;
	private String fax;
	private String email;
	private String contact;
	private Double initialReceivable;
	private Double totalReceivable;
	private Double initialAccountPayable;
	private Double totalAccountPayable;
	private String memo;


	public Company() {
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

	@Column(name = "company_code", unique = true, nullable = false, length = 12)
	public String getCompanyCode() {
		return this.companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	@Column(name = "company_category", nullable = false)
	public Integer getCompanyCategory() {
		return this.companyCategory;
	}

	public void setCompanyCategory(Integer companyCategory) {
		this.companyCategory = companyCategory;
	}

	@Column(name = "company_name", nullable = false, length = 24)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "tel", length = 15)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "address", length = 64)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "zip_code", length = 6)
	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Column(name = "fax", length = 15)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "email", length = 24)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "contact", length = 12)
	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(name = "initial_receivable", precision = 10, scale = 9)
	public Double getInitialReceivable() {
		return this.initialReceivable;
	}

	public void setInitialReceivable(Double initialReceivable) {
		this.initialReceivable = initialReceivable;
	}

	@Column(name = "total_receivable", precision = 10, scale = 9)
	public Double getTotalReceivable() {
		return this.totalReceivable;
	}

	public void setTotalReceivable(Double totalReceivable) {
		this.totalReceivable = totalReceivable;
	}

	@Column(name = "initial_account_payable", precision = 10, scale = 9)
	public Double getInitialAccountPayable() {
		return this.initialAccountPayable;
	}

	public void setInitialAccountPayable(Double initialAccountPayable) {
		this.initialAccountPayable = initialAccountPayable;
	}

	@Column(name = "total_account_payable", precision = 10, scale = 9)
	public Double getTotalAccountPayable() {
		return this.totalAccountPayable;
	}

	public void setTotalAccountPayable(Double totalAccountPayable) {
		this.totalAccountPayable = totalAccountPayable;
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
				.format("Company [id=%s, companyCode=%s, companyCategory=%s, companyName=%s, tel=%s, address=%s, zipCode=%s, fax=%s, email=%s, contact=%s, initialReceivable=%s, totalReceivable=%s, initialAccountPayable=%s, totalAccountPayable=%s, memo=%s]",
						id, companyCode, companyCategory, companyName, tel,
						address, zipCode, fax, email, contact,
						initialReceivable, totalReceivable,
						initialAccountPayable, totalAccountPayable, memo);
	}

	
	@Transient
	public String getCompanyCategoryName(){
		switch (companyCategory) {
		case 1:
			return BaseContext.CompanyCategoryMap.COMPANY_CATEGORY_SELLTOME.getCompanyCate();
		case 2:
			return BaseContext.CompanyCategoryMap.COMPANY_CATEGORY_BUYFROMME.getCompanyCate();
		default:
			return null;
		}
	}
}