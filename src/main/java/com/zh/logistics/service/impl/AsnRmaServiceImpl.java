package com.zh.logistics.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zh.logistics.dao.InvoiceDao;
import com.zh.logistics.entity.Invoice;
import com.zh.logistics.service.AsnRmaService;
import com.zh.logistics.util.BaseContext;
import com.zh.logistics.util.Page;
/**
 * 采购退货单Service
 * @author zhanghao
 * 20150303
 * */
@Service("returnAsnService")
public class AsnRmaServiceImpl implements AsnRmaService{

	private InvoiceDao invoiceDao;
	
	@Override
	public Invoice save(Invoice t) {
		t.setInvoiceType(BaseContext.INVOICE_TYPE_ASN_RMA);
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
		t.setInvoiceType(BaseContext.INVOICE_TYPE_ASN_RMA);
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
