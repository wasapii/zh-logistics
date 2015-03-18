package com.zh.logistics.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.log4j.Logger;

import com.zh.logistics.entity.Invoice;
import com.zh.logistics.entity.InvoiceDetails;
import com.zh.logistics.service.AsnRmaService;
import com.zh.logistics.util.FormatDateUtil;
import com.zh.logistics.util.Page;

/**
 * 退货单action(包括销售退货、进货退货)
 * 
 * @author zhanghao 20150316
 * 
 * */
public class AsnRmaAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(AsnRmaAction.class);

	private AsnRmaService asnRmaService;
	
	private Invoice invoice;

	private List<Invoice> invoiceList;
	
	List<InvoiceDetails> invoiceDetails = new ArrayList<InvoiceDetails>();
	
	public String queryAsnRma() {
		try {
			int total = asnRmaService.getAllcount(invoice);
			page.setTotal(total);
			page.setTotalPage(Page.caluTotalPage(total, page.getPageSize()));
			invoiceList = asnRmaService.query(invoice, page);
			message = "success";
			logger.info("查询成功" + invoiceList);
			return "list";
		} catch (RuntimeException e) {
			logger.error("查询失败", e);
			throw e;
		}

	}

	public String queryAsnRmaAll() {
		try {
			invoice = new Invoice();
			int total = asnRmaService.getAllcount(invoice);
			page = new Page();
			page.setTotal(total);
			page.setLocalPage(1);
			page.setTotalPage(Page.caluTotalPage(total, page.getPageSize()));
			invoiceList = asnRmaService.query(invoice, page);
			message = "success";
			logger.info("查询成功" + invoiceList);
			return "list";
		} catch (RuntimeException re) {
			logger.error("查询失败", re);
			throw re;
		}

	}

	public String updateAsnRma() {
		try {
			List<InvoiceDetails> DetailsList = invoice.getInvoiceDetails();
			for (InvoiceDetails invoiceDetail : DetailsList) {
				invoiceDetail.setInvoice(invoice);
				invoiceDetails.add(invoiceDetail);
			}
			invoice.setInvoiceDetails(invoiceDetails);
			asnRmaService.update(invoice);
			return queryAsnRmaAll();
		} catch (RuntimeException re) {
			logger.error("更新失败", re);
			throw re;    
		}

	}
	                                                                                                                            
	public String addAsnRma() {
		try {
			List<InvoiceDetails> DetailsList = invoice.getInvoiceDetails();
			for (InvoiceDetails invoiceDetail : DetailsList) {
				invoiceDetail.setInvoice(invoice);
				invoiceDetails.add(invoiceDetail);
			}
			invoice.setInvoiceDetails(invoiceDetails);
			asnRmaService.save(invoice);
			return queryAsnRmaAll();
		} catch (RuntimeException re) {
			logger.error("新增失败", re);
			throw re;
		}
	}

	public String deleteAsnRma() {
		try {
			logger.info("进入了delete方法，Id:" + id);
			String[] idList = FormatDateUtil.StringFormatArray(id);
			for (String delId : idList) {
				asnRmaService.delete(Integer.parseInt(delId));
				logger.info("删除结算账户信息成功,删除ID:" + delId);
			}
			return queryAsnRmaAll();
		} catch (RuntimeException re) {
			logger.error("删除失败", re);
			throw re;
		}
	}

	public String toUpdateAsnRma() {
		try {
			logger.info("获取到的进货单ID信息为：" + invoice.getId());
			invoice = asnRmaService.getById(invoice.getId());
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
			invoice = asnRmaService.getById(Integer.parseInt(id));
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

	

	public AsnRmaService getAsnRmaService() {
		return asnRmaService;
	}

	public void setAsnRmaService(AsnRmaService asnRmaService) {
		this.asnRmaService = asnRmaService;
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
