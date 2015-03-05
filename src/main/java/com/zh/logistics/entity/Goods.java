package com.zh.logistics.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商品信息
 * 
 * @author zhanghao 20150203
 */
@Entity
@Table(name = "goods", catalog = "mylogistics")
public class Goods implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String goodsCode;
	private String goodsBatch;
	private String goodsName;
	private String category;
	private String categoryName;
	private String barCode;
	private String unit;
	private String specifications;
	private String memo;

	// Constructors

	/** default constructor */
	public Goods() {
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

	@Column(name = "goods_code", unique = true, nullable = false, length = 15)
	public String getGoodsCode() {
		return this.goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	@Column(name = "goods_batch", length = 12)
	public String getGoodsBatch() {
		return this.goodsBatch;
	}

	public void setGoodsBatch(String goodsBatch) {
		this.goodsBatch = goodsBatch;
	}

	@Column(name = "goods_name", nullable = false, length = 24)
	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Column(name = "category", nullable = false, length = 12)
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "bar_code", length = 24)
	public String getBarCode() {
		return this.barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	@Column(name = "unit", length = 5)
	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "specifications", length = 24)
	public String getSpecifications() {
		return this.specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	@Column(name = "memo", length = 200)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "category_name")
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return String
				.format("Goods [id=%s, goodsCode=%s, goodsBatch=%s, goodsName=%s, category=%s, categoryName=%s, barCode=%s, unit=%s, specifications=%s, memo=%s]",
						id, goodsCode, goodsBatch, goodsName, category,
						categoryName, barCode, unit, specifications, memo);
	}
}