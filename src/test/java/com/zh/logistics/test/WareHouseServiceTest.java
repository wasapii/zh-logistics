package com.zh.logistics.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zh.logistics.entity.Warehouse;
import com.zh.logistics.service.WarehouseService;
import com.zh.logistics.util.Page;

public class WareHouseServiceTest {
	private static Logger logger = Logger.getLogger(WareHouseServiceTest.class);
	ApplicationContext applicationContext;
	WarehouseService warehouseService;
	
	@Before
	public void loadXml(){
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		warehouseService = (WarehouseService) applicationContext.getBean("warehouseService");
	}
	@Test
	public void saveTest(){
		Warehouse warehouse = new Warehouse();
		warehouse.setWarehouseCode("TEST00001");
		warehouse.setWarehouseName("测试一号仓");
		warehouse.setAddress("双城国际6楼");
		warehouse.setContacts("张水告");
		warehouse.setTel("15268801900");
		warehouse.setMemo("测试一号仓数据存储");
		logger.info("11111111111");
		//for (int i = 0; i < 35; i++) {
		// JdbcContextHolder.setSlave();
//		 JdbcContextHolder.setMaster();
//			warehouse.setWarehouseCode("AA00001");
//			warehouseService.save(warehouse);
		//}
	}
	
	@Test
	public void saveOrUpdate(){
		Warehouse warehouse = new Warehouse();
		warehouse.setWarehouseCode("TEST00001");
		warehouse.setWarehouseName("测试一号仓");
		warehouse.setAddress("双城国际6楼");
		warehouse.setContacts("张水告");
		warehouse.setTel("15268801900");
		warehouse.setMemo("测试一号仓数据存储");
	}
	
	@Test
	public void queryTest(){
		Page page = new Page();
		page.setLocalPage(1);
		page.setPageSize(15);
		List<Warehouse> list = warehouseService.query(new Warehouse(),page);
		for (Warehouse warehouse : list) {
			System.out.println(warehouse);
		}
	}
	
	@Test
	public void delete(){
		warehouseService.delete(46);
	}
	
	@Test
	public void tesGetWarehouse(){
		Warehouse warehouse =  warehouseService.getByWarehouseCode("ffg");
		System.out.println(warehouse);
	}
}
