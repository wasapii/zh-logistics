package com.zh.logistics.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zh.logistics.dao.CompanyDao;
import com.zh.logistics.dao.GoodsDao;
import com.zh.logistics.dao.InventoryDao;
import com.zh.logistics.dao.InvoiceDao;
import com.zh.logistics.dao.WarehouseDao;
import com.zh.logistics.entity.Company;
import com.zh.logistics.entity.Goods;
import com.zh.logistics.entity.Inventory;
import com.zh.logistics.entity.Invoice;
import com.zh.logistics.entity.InvoiceDetails;
import com.zh.logistics.entity.Warehouse;
import com.zh.logistics.service.SalesOrderService;
import com.zh.logistics.util.BaseContext;
import com.zh.logistics.util.CreateNum;
import com.zh.logistics.util.Page;

@Service("salesOrderService")
public class SalesOrderServiceImpl implements SalesOrderService {

	private static final Logger logger = Logger
			.getLogger(SalesOrderServiceImpl.class);

	private InvoiceDao invoiceDao;

	private WarehouseDao warehouseDao;

	private CompanyDao companyDao;

	private InventoryDao inventoryDao;

	@Override
	public Invoice save(Invoice invoice) {
		String num = CreateNum.createInvoiceNum(
				invoiceDao.getMaxInvoiceNum(BaseContext.NUM_CREATE_HEAD_SALES),
				BaseContext.NUM_CREATE_HEAD_SALES);
		invoice.setInvoiceNum(num);
		// 验证仓库信息是否存在
		Warehouse warehouse = warehouseDao.getByWarehouseCode(invoice
				.getWarehouseCode());
		if (warehouse == null) {
			String msg = "无此仓库编号：" + invoice.getWarehouseCode();
			logger.error(msg);
			throw new RuntimeException(msg);
		}
		// 验证供货单位是否存在
		Company company = companyDao.getByCompanyCode(invoice.getCompany());
		if (company == null) {
			String msg = "无此购买单位信息：" + invoice.getCompany();
			logger.error(msg);
			throw new RuntimeException(msg);
		}
		// 验证商品信息是否存在若不存在则返回错误 无此商品销售
		List<InvoiceDetails> invoiceDetails = invoice.getInvoiceDetails();
		if (invoiceDetails == null || invoiceDetails.size() == 0) {
			String msg = "该销售入库单无商品信息 ： " + invoice.getInvoiceNum();
			logger.error(msg);
			throw new RuntimeException(msg);
		}
		// 保存单据信息
		invoice.setInvoiceType(BaseContext.INVOICE_TYPE_SALE);
		Date date = new Date();
		invoice.setInvoiceDate(date);
		invoice.setInvoiceTime(new Timestamp(date.getTime()));
		invoice = invoiceDao.save(invoice);
		invoice.setOperator("操作人");
		// 更新对应仓库库存量
		for (InvoiceDetails newinvoiceDetails : invoiceDetails) {
			// 根据仓库编码与商品编码查找库存量（前提：各仓库定义好存放哪些商品）
			Inventory inventory = inventoryDao.getByWarehouseCode(
					invoice.getWarehouseCode(),
					newinvoiceDetails.getGoodsCode());
			if ("".equals(inventory) || inventory == null) {// 若不存在该商品则新增
				String msg = "该仓库" + invoice.getWarehouseCode() + "库存中不存在该商品："
						+ newinvoiceDetails.getGoodsCode();
				logger.error(msg);
				throw new RuntimeException(msg);
			}
			if (inventory.getInventoryNum() < newinvoiceDetails.getGoodsNum()) {// 库存量<销售入库单数量
				String msg = "该仓库" + invoice.getWarehouseCode() + "库存中该商品："
						+ newinvoiceDetails.getGoodsCode() + "存量不足";
				logger.error(msg);
				throw new RuntimeException(msg);
			}
			inventory.setInventoryNum(inventory.getInventoryNum()
					- newinvoiceDetails.getGoodsNum());
			logger.info("库存信息：" + inventory);
			inventoryDao.save(inventory);
		}
		return invoice;
	}

	@Override
	public void update(Invoice invoice) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Invoice> query(Invoice invoice, Page page) {
		invoice.setInvoiceType(BaseContext.INVOICE_TYPE_SALE);
		return invoiceDao.query(invoice, page);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getAllcount(Invoice invoice) {
		invoice.setInvoiceType(BaseContext.INVOICE_TYPE_SALE);
		return invoiceDao.getAllcount(invoice);
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

	public WarehouseDao getWarehouseDao() {
		return warehouseDao;
	}

	public void setWarehouseDao(WarehouseDao warehouseDao) {
		this.warehouseDao = warehouseDao;
	}

	public CompanyDao getCompanyDao() {
		return companyDao;
	}

	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	public InventoryDao getInventoryDao() {
		return inventoryDao;
	}

	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}
	
	
}
