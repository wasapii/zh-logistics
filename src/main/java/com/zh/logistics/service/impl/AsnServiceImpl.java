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
import com.zh.logistics.service.AsnService;
import com.zh.logistics.util.BaseContext;
import com.zh.logistics.util.CreateNum;
import com.zh.logistics.util.Page;

@Service("asnService")
public class AsnServiceImpl implements AsnService{

	private static final Logger logger = Logger.getLogger(AsnServiceImpl.class);
	
	private InvoiceDao invoiceDao;
	
	private WarehouseDao warehouseDao;
	
	private CompanyDao companyDao;
	
	private GoodsDao goodsDao;
	
	private InventoryDao inventoryDao;
	
	@Override
	public Invoice save(Invoice invoice) {
		String num = CreateNum.createInvoiceNum(invoiceDao.getMaxInvoiceNum(), BaseContext.ASN_NUM_CREATE_HEAD);
		invoice.setInvoiceNum(num);
		//验证仓库信息是否存在
		Warehouse warehouse = warehouseDao.getByWarehouseCode(invoice.getWarehouseCode());
		if (warehouse == null) {
			logger.error("无此仓库编号：" + invoice.getWarehouseCode());
		}
		//验证供货单位是否存在
		Company company = companyDao.getByCompanyCode(invoice.getCompany());
		if (company == null) {
			logger.error("无此供货单位信息：" + invoice.getCompany());
		}
		//验证商品信息是否存在若不存在则新增基础信息中的商品信息
		List<InvoiceDetails> invoiceDetails = invoice.getInvoiceDetails();
		if (invoiceDetails == null || invoiceDetails.size() == 0) {
			logger.error("该进货单无商品信息 ： " + invoice.getInvoiceNum());
		}
		for (InvoiceDetails newinvoiceDetails : invoiceDetails) {
			Goods goods = goodsDao.getByGoodsCode(newinvoiceDetails.getGoodsCode());
			if ("".equals(goods) || goods == null) {
				logger.error("该商品信息不存在，新增至基础商品信息中,商品编号为：" + newinvoiceDetails.getGoodsCode());
				Goods newGoods = new Goods();
				newGoods.setGoodsCode(newinvoiceDetails.getGoodsCode());
				newGoods.setGoodsName(newinvoiceDetails.getGoodsName());
				newGoods.setUnit(newinvoiceDetails.getGoodsUnit());
				newGoods.setCategory(BaseContext.DEFAULT_CATEGORY);
				goodsDao.save(newGoods);
			}
		}
		//保存单据信息
		invoice.setInvoiceType(BaseContext.INVOICE_TYPE_ASN);
		Date date = new Date();
		invoice.setInvoiceDate(date);
		invoice.setInvoiceTime(new Timestamp(date.getTime()));
		invoice = invoiceDao.save(invoice);
		invoice.setOperator("操作人");
		//更新对应仓库库存量
		for (InvoiceDetails newinvoiceDetails : invoiceDetails) {
			//根据仓库编码与商品编码查找库存量（前提：各仓库定义好存放哪些商品）
			Inventory inventory = inventoryDao.getByWarehouseCode(invoice.getWarehouseCode(),newinvoiceDetails.getGoodsCode());
			if ("".equals(inventory) || inventory == null) {//若不存在该商品则新增
				logger.error("该仓库"+ invoice.getWarehouseCode() +"库存中不存在该商品：" + newinvoiceDetails.getGoodsCode());
				Inventory newInventory = new Inventory();
				newInventory.setWarehouseCode(invoice.getWarehouseCode());
				newInventory.setGoodsCode(newinvoiceDetails.getGoodsCode());
				newInventory.setGoodsName(newinvoiceDetails.getGoodsName());
				newInventory.setGoodsUnit(newinvoiceDetails.getGoodsUnit());
				newInventory.setInventoryNum(newinvoiceDetails.getGoodsNum());
				logger.info("库存信息：" + newInventory);
				inventoryDao.save(newInventory);
			}else{
				//inventory.setInventoryPrice(newinvoiceDetails.getGoodsUnitPrice());//暂时不涉及金额相关内容
				inventory.setInventoryNum(inventory.getInventoryNum() + newinvoiceDetails.getGoodsNum());
				logger.info("库存信息：" + inventory);
				inventoryDao.save(inventory);				
			}
		}
		return invoice;
		
	}

	@Override
	public void update(Invoice t) {
		invoiceDao.update(t);
	}

	@Override
	public List<Invoice> query(Invoice t, Page page) {
		t.setInvoiceType(BaseContext.INVOICE_TYPE_ASN);
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

	public GoodsDao getGoodsDao() {
		return goodsDao;
	}

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	public InventoryDao getInventoryDao() {
		return inventoryDao;
	}

	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}
	
	public String getMax(){
		return invoiceDao.getMaxInvoiceNum();
	}
}
