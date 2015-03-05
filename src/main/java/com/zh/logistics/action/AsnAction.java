package com.zh.logistics.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.log4j.Logger;

import com.zh.logistics.entity.Invoice;
import com.zh.logistics.entity.InvoiceDetails;
import com.zh.logistics.service.AsnService;
import com.zh.logistics.util.DataFormat;
import com.zh.logistics.util.Page;

/**
 * 进货单action
 * 
 * @author zhanghao 20150209
 * 
 * */
public class AsnAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(AsnAction.class);

	private AsnService asnService;

	private Invoice invoice;

	private List<Invoice> invoiceList;
	
	List<InvoiceDetails> invoiceDetails = new ArrayList<InvoiceDetails>();
	
	public String query() {
		try {
			int total = asnService.getAllcount(invoice);
			page.setTotal(total);
			page.setTotalPage(Page.caluTotalPage(total, page.getPageSize()));
			invoiceList = asnService.query(invoice, page);
			message = "success";
			logger.info("查询成功" + invoiceList);
			return "list";
		} catch (RuntimeException e) {
			logger.error("查询失败", e);
			throw e;
		}

	}

	public String queryAll() {
		try {
			invoice = new Invoice();
			int total = asnService.getAllcount(invoice);
			page = new Page();
			page.setTotal(total);
			page.setLocalPage(1);
			page.setTotalPage(Page.caluTotalPage(total, page.getPageSize()));
			invoiceList = asnService.query(invoice, page);
			message = "success";
			logger.info("查询成功" + invoiceList);
			return "list";
		} catch (RuntimeException re) {
			logger.error("查询失败", re);
			throw re;
		}

	}

	public String updateAsn() {
		try {
			List<InvoiceDetails> DetailsList = invoice.getInvoiceDetails();
			for (InvoiceDetails invoiceDetail : DetailsList) {
				invoiceDetail.setInvoice(invoice);
				invoiceDetails.add(invoiceDetail);
			}
			invoice.setInvoiceDetails(invoiceDetails);
			asnService.update(invoice);
			return queryAll();
		} catch (RuntimeException re) {
			logger.error("更新失败", re);
			throw re;    
		}

	}
	                                                                                                                            
	public String addAsn() {
		try {
			List<InvoiceDetails> DetailsList = invoice.getInvoiceDetails();
			for (InvoiceDetails invoiceDetail : DetailsList) {
				invoiceDetail.setInvoice(invoice);
				invoiceDetails.add(invoiceDetail);
			}
			invoice.setInvoiceDetails(invoiceDetails);
			asnService.save(invoice);
			return queryAll();
		} catch (RuntimeException re) {
			logger.error("新增失败", re);
			throw re;
		}
	}

	public String deleteAsn() {
		try {
			logger.info("进入了delete方法，Id:" + id);
			String[] idList = DataFormat.StringFormatArray(id);
			for (String delId : idList) {
				asnService.delete(Integer.parseInt(delId));
				logger.info("删除结算账户信息成功,删除ID:" + delId);
			}
			return queryAll();
		} catch (RuntimeException re) {
			logger.error("删除失败", re);
			throw re;
		}
	}

	public String toUpdate() {
		try {
			logger.info("获取到的进货单ID信息为：" + invoice.getId());
			invoice = asnService.getById(invoice.getId());
			logger.info("查询ID为：" + invoice.getId() + "的仓库信息为：" + invoice);
			return "update";
		} catch (RuntimeException re) {
			logger.error("查询失败", re);
			throw re;
		}
	}

	public String queryDetail(){
		try {
			logger.info("获取到的进货单ID信息为：" + id);
			invoice = asnService.getById(Integer.parseInt(id));
			List<InvoiceDetails> details = invoice.getInvoiceDetails();
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setIgnoreDefaultExcludes(false);
			jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			JSONArray json = JSONArray.fromObject(details,jsonConfig);
			message = json.toString();
			return SUCCESS;
		} catch (RuntimeException re) {
			logger.error("查询失败", re);
			throw re;
		}
	} 

	public AsnService getAsnService() {
		return asnService;
	}

	public void setAsnService(AsnService asnService) {
		this.asnService = asnService;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public List<Invoice> getInvoiceList() {
		return invoiceList;
	}

	public void setInvoiceList(List<Invoice> invoiceList) {
		this.invoiceList = invoiceList;
	}

	public List<InvoiceDetails> getInvoiceDetails() {
		return invoiceDetails;
	}

	public void setInvoiceDetails(List<InvoiceDetails> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}

}
