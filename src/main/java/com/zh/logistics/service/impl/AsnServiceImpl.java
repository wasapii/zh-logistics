package com.zh.logistics.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zh.logistics.dao.InvoiceDao;
import com.zh.logistics.entity.Invoice;
import com.zh.logistics.service.AsnService;
import com.zh.logistics.util.BaseContext;
import com.zh.logistics.util.Page;

@Service("asnService")
public class AsnServiceImpl implements AsnService{

	private InvoiceDao invoiceDao;
	
	@Override
	public Invoice save(Invoice t) {
		t.setInvoiceType(BaseContext.INVOICE_TYPE_ASN);
		t.setInvoiceDate(new Date());
		t.setInvoiceTime(new Date());
		t.setWarehouseCode("12414");
		return invoiceDao.save(t);
	}

	@Override
	public void update(Invoice t) {
		invoiceDao.update(t);
	}

	@Override
	public List<Invoice> query(Invoice t, Page page) {
		return invoiceDao.query(t, page);
	}

	@Override
	public void delete(int id) {
		invoiceDao.delete(id);		
	}

	@Override
	public int getAllcount(Invoice t) {
		t.setInvoiceType(BaseContext.INVOICE_TYPE_ASN);
		return invoiceDao.getAllcount(t);
	}

	@Override
	public Invoice getById(int id) {
		return invoiceDao.getById(id);
	}

	public InvoiceDao getInvoiceDao() {
		return invoiceDao;
	}

	public void setInvoiceDao(InvoiceDao invoiceDao) {
		this.invoiceDao = invoiceDao;
	}

}
