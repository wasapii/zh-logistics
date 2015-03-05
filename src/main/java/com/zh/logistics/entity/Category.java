package com.zh.logistics.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 类别
 * 
 * @author zhanghao 20150205
 */
@Entity
@Table(name = "category", catalog = "mylogistics")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String categoryCode;
	private String categoryName;
	private String parentCode;

	public Category() {
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

	@Column(name = "category_code", unique = true, nullable = false, length = 12)
	public String getCategoryCode() {
		return this.categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	@Column(name = "category_name", length = 12)
	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Column(name = "parent_code", length = 12)
	public String getParentCode() {
		return this.parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	@Override
	public String toString() {
		return String
				.format("Category [id=%s, categoryCode=%s, categoryName=%s, parentCode=%s]",
						id, categoryCode, categoryName, parentCode);
	}

}