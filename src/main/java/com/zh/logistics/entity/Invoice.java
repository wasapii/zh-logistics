package com.zh.logistics.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.zh.logistics.util.BaseContext;
import com.zh.logistics.util.DataFormat;

/**
 * 进货单
 * @author zhanghao
 * 20150209
 */
@Entity
@Table(name = "invoice", catalog = "mylogistics")
public class Invoice implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String invoiceNum;
	private String superiorsOrderNum;
	private Date invoiceDate;
	private Date invoiceTime;
	private Integer invoiceType;
	private String company;
	private Double paidAmount;
	private Double wipeZeroAmount;
	private String operator;
	private String warehouseCode;
	private String memo;
	private String payee;
	private Double paymentAmount;
	private List<InvoiceDetails> invoiceDetails = new ArrayList<InvoiceDetails>();
	private String startDate;//不映射数据库
	private String endDate;
	
	private String originalNum;
	
	public Invoice() {
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

	@Column(name = "invoice_num", nullable = false, length = 15)
	public String getInvoiceNum() {
		return this.invoiceNum;
	}

	@Column(name = "superiors_order_num", length = 24)
	public String getSuperiorsOrderNum() {
		return this.superiorsOrderNum;
	}

	public void setSuperiorsOrderNum(String superiorsOrderNum) {
		this.superiorsOrderNum = superiorsOrderNum;
	}

	@Column(name = "invoice_date", nullable = false, length = 19)
	public Date getInvoiceDate() {
		return this.invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	@Column(name = "invoice_time", nullable = false, length = 19)
	public Date getInvoiceTime() {
		return this.invoiceTime;
	}

	public void setInvoiceTime(Date invoiceTime) {
		this.invoiceTime = invoiceTime;
	}

	@Column(name = "invoice_type", nullable = false)
	public Integer getInvoiceType() {
		return this.invoiceType;
	}

	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
	}

	@Column(name = "company", length = 12)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "paid_amount", precision = 20, scale = 9)
	public Double getPaidAmount() {
		return this.paidAmount;
	}

	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}

	@Column(name = "wipe_zero_amount", precision = 20, scale = 9)
	public Double getWipeZeroAmount() {
		return this.wipeZeroAmount;
	}

	public void setWipeZeroAmount(Double wipeZeroAmount) {
		this.wipeZeroAmount = wipeZeroAmount;
	}

	@Column(name = "operator", length = 12)
	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Column(name = "warehouse_code", nullable = false, length = 12)
	public String getWarehouseCode() {
		return this.warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	@Column(name = "memo", length = 200)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "payee", length = 12)
	public String getPayee() {
		return this.payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	@Column(name = "paymentAmount", precision = 20, scale = 9)
	public Double getPaymentAmount() {
		return this.paymentAmount;
	}

	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "invoice")
	public List<InvoiceDetails> getInvoiceDetails() {
		return invoiceDetails;
	}

	public void setInvoiceDetails(List<InvoiceDetails> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}


	@Column(name = "original_num")
	public String getOriginalNum() {
		return originalNum;
	}

	public void setOriginalNum(String originalNum) {
		this.originalNum = originalNum;
	}

	@Transient
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	@Transient
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Transient
	public String getInvoiceFormatDate() {
		return DataFormat.formatDateToString(invoiceDate);
	}
	@Transient
	public String getInvoiceFormatTime() {
		return DataFormat.formatTimeToString(invoiceTime);
	}
	
	@Transient
	public String getInvoiceTypeName(){
		switch (invoiceType) {
		case 1:
			return BaseContext.InvoiceType.ASN.getInvoiceType();
		case 2:
			return BaseContext.InvoiceType.SALE.getInvoiceType();
		case -1:
			return BaseContext.InvoiceType.ASN_RMA.getInvoiceType();
		case -2:
			return BaseContext.InvoiceType.SALE_RMA.getInvoiceType();
		case 3:
			return BaseContext.InvoiceType.ASN_OTHERS.getInvoiceType();
		case 4:
			return BaseContext.InvoiceType.SALE_OTHERS.getInvoiceType();
		default:
			return null;
		}
	}

	@Override
	public String toString() {
		return String
				.format("Invoice [id=%s, invoiceNum=%s, superiorsOrderNum=%s, invoiceDate=%s, invoiceTime=%s, invoiceType=%s, company=%s, paidAmount=%s, wipeZeroAmount=%s, operator=%s, warehouseCode=%s, memo=%s, payee=%s, paymentAmount=%s, startDate=%s, endDate=%s, originalNum=%s]",
						id, invoiceNum, superiorsOrderNum, invoiceDate,
						invoiceTime, invoiceType, company, paidAmount,
						wipeZeroAmount, operator, warehouseCode, memo, payee,
						paymentAmount, startDate, endDate, originalNum);
	}
	
}