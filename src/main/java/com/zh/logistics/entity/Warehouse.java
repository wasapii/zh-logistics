package com.zh.logistics.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "warehouse")
public class Warehouse implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String warehouseCode;
	private String warehouseName;
	private String address;
	private String contacts;
	private String tel;
	private String memo;

	@Id
	@GeneratedValue
	@Column(name = "id" , nullable = false,unique = true)
	public Integer getId(  ) {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "warehouse_code" , nullable = false,unique = true)
	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	@Column(name = "warehouse_name", nullable = false, length = 64)
	public String getWarehouseName() {
		return this.warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	} 

	@Column(name = "address", length = 64)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "contacts", length = 32)
	public String getContacts() {
		return this.contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
 
	@Column(name = "tel", length = 12)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "memo", length = 64)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return String
				.format("Warehouse [id=%s, warehouseCode=%s, warehouseName=%s, address=%s, contacts=%s, tel=%s, memo=%s]",
						id, warehouseCode, warehouseName, address, contacts,
						tel, memo);
	}

}