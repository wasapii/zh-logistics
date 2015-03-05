package com.zh.logistics.action;

import java.util.List;
import org.apache.log4j.Logger;
import com.zh.logistics.entity.Warehouse;
import com.zh.logistics.service.WarehouseService;
import com.zh.logistics.util.DataFormat;
import com.zh.logistics.util.Page;

public class WarehouseAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(WarehouseAction.class);

	private Warehouse warehouse;

	private List<Warehouse> warehouses;

	private WarehouseService warehouseService;

	public String query() {
		int total = warehouseService.getAllcount(warehouse);
		logger.info("查询成功所得记录数为：" + total);
		page.setTotal(total);
		page.setTotalPage(Page.caluTotalPage(total, page.getPageSize()));
		warehouses = warehouseService.query(warehouse, page);
		logger.info("查询成功记录为：" + warehouses);
		return "list";
	}

	/**
	 * 更新、保存、删除返回列表
	 * */
	public String queryAll() {
		warehouse = new Warehouse();
		int total = warehouseService.getAllcount(warehouse);
		logger.info("查询成功所得记录数为：" + total);
		page = new Page();
		page.setLocalPage(1);
		page.setTotal(total);
		page.setTotalPage(Page.caluTotalPage(total, page.getPageSize()));
		warehouses = warehouseService.query(warehouse, page);
		logger.info("查询成功记录为：" + warehouses);
		return "list";

	}

	public String addWarehouse() {
		logger.info("into add，仓库实体信息为：" + warehouse);
		warehouseService.save(warehouse);
		logger.info("仓库信息保存成功为,当前记录为：" + warehouse);
		return queryAll();
	}

	public String toUpdateWarehouse() {
		logger.info("获取到的仓库ID信息为：" + id);
		warehouse = warehouseService.getById(warehouse.getId());
		logger.info("查询ID为：" + id + "的仓库信息为：" + warehouse);
		return "update";
	}

	public String updateWarehouse() {
		warehouseService.update(warehouse);
		logger.info("更新仓库信息成功" + warehouse);
		return queryAll();
	}

	public String delete(){
		logger.info("进入了delete方法，Id:" + id);
		String[] idList = DataFormat.StringFormatArray(id);
		for (String delId : idList) {
			warehouseService.delete(Integer.parseInt(delId));
			logger.info("删除仓库信息成功,删除ID:" + delId);
		}
		return "list";
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public WarehouseService getWarehouseService() {
		return warehouseService;
	}

	public void setWarehouseService(WarehouseService warehouseService) {
		this.warehouseService = warehouseService;
	}

	public List<Warehouse> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(List<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}


}
