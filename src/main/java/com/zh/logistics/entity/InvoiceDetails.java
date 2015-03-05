package com.zh.logistics.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 进货单从表
 * @author zhanghao
 * 20150209
 */
@Entity
@Table(name = "invoice_details", catalog = "mylogistics")
public class InvoiceDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String goodsCode;
	private String goodsName;
	private String goodsUnit;
	private Integer goodsNum;
	private Double goodsUnitPrice;
	private Double discount;
	private Double discountUnitPrice;
	private Double discountAmount;
	private Double goodsSumPrice;
	private String memo;
	private Invoice invoice;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "invoice_num", referencedColumnName = "invoice_num", nullable = false)
	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	@Column(name = "goods_code", nullable = false, length = 15)
	public String getGoodsCode() {
		return this.goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	@Column(name = "goods_name", length = 24)
	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Column(name = "goods_unit", length = 5)
	public String getGoodsUnit() {
		return this.goodsUnit;
	}

	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}

	@Column(name = "goods_num", nullable = false)
	public Integer getGoodsNum() {
		return this.goodsNum;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	@Column(name = "goods_unit_price", nullable = false, precision = 10, scale = 9)
	public Double getGoodsUnitPrice() {
		return this.goodsUnitPrice;
	}

	public void setGoodsUnitPrice(Double goodsUnitPrice) {
		this.goodsUnitPrice = goodsUnitPrice;
	}

	@Column(name = "discount", precision = 10, scale = 9)
	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	@Column(name = "discount_unit_price", precision = 10, scale = 9)
	public Double getDiscountUnitPrice() {
		return this.discountUnitPrice;
	}

	public void setDiscountUnitPrice(Double discountUnitPrice) {
		this.discountUnitPrice = discountUnitPrice;
	}

	@Column(name = "discount_amount", precision = 10, scale = 9)
	public Double getDiscountAmount() {
		return this.discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	@Column(name = "goods_sum_price", nullable = false, precision = 10, scale = 9)
	public Double getGoodsSumPrice() {
		return this.goodsSumPrice;
	}

	public void setGoodsSumPrice(Double goodsSumPrice) {
		this.goodsSumPrice = goodsSumPrice;
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
				.format("InvoiceDetails [id=%s, goodsCode=%s, goodsName=%s, goodsUnit=%s, goodsNum=%s, goodsUnitPrice=%s, discount=%s, discountUnitPrice=%s, discountAmount=%s, goodsSumPrice=%s, memo=%s]",
						id, goodsCode, goodsName, goodsUnit, goodsNum,
						goodsUnitPrice, discount, discountUnitPrice,
						discountAmount, goodsSumPrice, memo);
	}

}