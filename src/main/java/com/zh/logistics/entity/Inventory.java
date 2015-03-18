package com.zh.logistics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 库存实体
 *  @author zhangaho 20150316
 */
@Entity
@Table(name = "inventory", catalog = "mylogistics")
public class Inventory implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String warehouseCode;
	private String goodsCode;
	private String goodsName;
	private String goodsUnit;
	private Integer beginInvtrNum;
	private Double beginInvtrPrice;
	private Double beginInvtrMoney;
	private Integer inventoryNum;
	private Double inventoryPrice;
	private Double inventoryMoney;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "warehouse_code", unique = true, nullable = false, length = 15)
	public String getWarehouseCode() {
		return this.warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	@Column(name = "goods_code", nullable = false, length = 15)
	public String getGoodsCode() {
		return this.goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	@Column(name = "goods_name", nullable = false, length = 24)
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

	@Column(name = "beginInvtrNum")
	public Integer getBeginInvtrNum() {
		return this.beginInvtrNum;
	}

	public void setBeginInvtrNum(Integer beginInvtrNum) {
		this.beginInvtrNum = beginInvtrNum;
	}

	@Column(name = "beginInvtrPrice", precision = 11, scale = 9)
	public Double getBeginInvtrPrice() {
		return this.beginInvtrPrice;
	}

	public void setBeginInvtrPrice(Double beginInvtrPrice) {
		this.beginInvtrPrice = beginInvtrPrice;
	}

	@Column(name = "beginInvtrMoney", precision = 20, scale = 9)
	public Double getBeginInvtrMoney() {
		return this.beginInvtrMoney;
	}

	public void setBeginInvtrMoney(Double beginInvtrMoney) {
		this.beginInvtrMoney = beginInvtrMoney;
	}

	@Column(name = "inventory_num")
	public Integer getInventoryNum() {
		return this.inventoryNum;
	}

	public void setInventoryNum(Integer inventoryNum) {
		this.inventoryNum = inventoryNum;
	}

	@Column(name = "inventory_price", precision = 11, scale = 9)
	public Double getInventoryPrice() {
		return this.inventoryPrice;
	}

	public void setInventoryPrice(Double inventoryPrice) {
		this.inventoryPrice = inventoryPrice;
	}

	@Column(name = "inventory_money", precision = 20, scale = 9)
	public Double getInventoryMoney() {
		return this.inventoryMoney;
	}

	public void setInventoryMoney(Double inventoryMoney) {
		this.inventoryMoney = inventoryMoney;
	}

	@Override
	public String toString() {
		return String
				.format("Inventory [id=%s, warehouseCode=%s, goodsCode=%s, goodsName=%s, goodsUnit=%s, beginInvtrNum=%s, beginInvtrPrice=%s, beginInvtrMoney=%s, inventoryNum=%s, inventoryPrice=%s, inventoryMoney=%s]",
						id, warehouseCode, goodsCode, goodsName, goodsUnit,
						beginInvtrNum, beginInvtrPrice, beginInvtrMoney,
						inventoryNum, inventoryPrice, inventoryMoney);
	}

}