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
import com.zh.logistics.service.AsnService;
import com.zh.logistics.service.CompanyService;
import com.zh.logistics.service.SalesOrderService;
import com.zh.logistics.service.WarehouseService;
import com.zh.logistics.util.FormatDateUtil;
import com.zh.logistics.util.Page;

/**
 * 销售出库单action
 * 
 * @author zhanghao 20150209
 * 
 * */
public class SalesOrderAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(SalesOrderAction.class);

	private SalesOrderService salesOrderService;

	private WarehouseService warehouseService;

	private CompanyService companyService;

	private Invoice invoice;

	private List<Invoice> invoiceList;

	List<InvoiceDetails> invoiceDetails = new ArrayList<InvoiceDetails>();

	public String querySalesOrder() {
		try {
			int total = salesOrderService.getAllcount(invoice);
			page.setTotal(total);
			page.setTotalPage(Page.caluTotalPage(total, page.getPageSize()));
			invoiceList = salesOrderService.query(invoice, page);
			for (Invoice invoice : invoiceList) {
				String warehoueName = warehouseService
						.getNameByWarehouseCode(invoice.getWarehouseCode());
				invoice.setWarehouseName(warehoueName);
				String companyName = companyService
						.getNameByCompanyCode(invoice.getCompany());
				invoice.setCompanyName(companyName);
			}
			message = "success";
			logger.info("查询成功" + invoiceList);
			return "list";
		} catch (RuntimeException e) {
			logger.error("查询失败", e);
			throw e;
		}

	}

	public String querySalesOrderAll() {
		try {
			invoice = new Invoice();
			int total = salesOrderService.getAllcount(invoice);
			page = new Page();
			page.setTotal(total);
			page.setLocalPage(1);
			page.setTotalPage(Page.caluTotalPage(total, page.getPageSize()));
			invoiceList = salesOrderService.query(invoice, page);
			message = "success";
			logger.info("查询成功" + invoiceList);
			return "list";
		} catch (RuntimeException re) {
			logger.error("查询失败", re);
			throw re;
		}

	}

	public String updateSalesOrder() {
		try {
			List<InvoiceDetails> DetailsList = invoice.getInvoiceDetails();
			for (InvoiceDetails invoiceDetail : DetailsList) {
				invoiceDetail.setInvoice(invoice);
				invoiceDetails.add(invoiceDetail);
			}
			invoice.setInvoiceDetails(invoiceDetails);
			salesOrderService.update(invoice);
			return querySalesOrderAll();
		} catch (RuntimeException re) {
			logger.error("更新失败", re);
			throw re;
		}

	}

	public String addSalesOrder() {
		try {
			List<InvoiceDetails> DetailsList = invoice.getInvoiceDetails();
			for (InvoiceDetails invoiceDetail : DetailsList) {
				invoiceDetail.setInvoice(invoice);
				invoiceDetails.add(invoiceDetail);
			}
			invoice.setInvoiceDetails(invoiceDetails);
			salesOrderService.save(invoice);
			return querySalesOrderAll();
		} catch (RuntimeException re) {
			logger.error("新增失败", re);
			throw re;
		}
	}

	public String deleteSalesOrder() {
		try {
			logger.info("进入了delete方法，Id:" + id);
			String[] idList = FormatDateUtil.StringFormatArray(id);
			for (String delId : idList) {
				salesOrderService.delete(Integer.parseInt(delId));
				logger.info("删除销售出库信息成功,删除ID:" + delId);
			}
			return querySalesOrderAll();
		} catch (RuntimeException re) {
			logger.error("删除失败", re);
			throw re;
		}
	}

	public String toUpdateSalesOrder() {
		try {
			logger.info("获取到的销售出库单ID信息为：" + invoice.getId());
			invoice = salesOrderService.getById(invoice.getId());
			logger.info("查询ID为：" + invoice.getId() + "的销售出库信息为：" + invoice);
			return "update";
		} catch (RuntimeException re) {
			logger.error("查询失败", re);
			throw re;
		}
	}

	public String queryDetail() {
		try {
			logger.info("获取到的销售出库单ID信息为：" + id);
			invoice = salesOrderService.getById(Integer.parseInt(id));
			List<InvoiceDetails> details = invoice.getInvoiceDetails();
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setIgnoreDefaultExcludes(false);
			jsonConfig
					.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			JSONArray json = JSONArray.fromObject(details, jsonConfig);
			message = json.toString();
			return SUCCESS;
		} catch (RuntimeException re) {
			logger.error("查询失败", re);
			throw re;
		}
	}

	public SalesOrderService getSalesOrderService() {
		return salesOrderService;
	}

	public void setSalesOrderService(SalesOrderService salesOrderService) {
		this.salesOrderService = salesOrderService;
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

	public WarehouseService getWarehouseService() {
		return warehouseService;
	}

	public void setWarehouseService(WarehouseService warehouseService) {
		this.warehouseService = warehouseService;
	}

	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

}
