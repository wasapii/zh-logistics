package com.zh.logistics.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.fabric.xmlrpc.base.Data;
import com.zh.logistics.entity.Invoice;
import com.zh.logistics.entity.InvoiceDetails;
import com.zh.logistics.entity.User;
import com.zh.logistics.service.AsnService;
import com.zh.logistics.service.UserService;
import com.zh.logistics.service.WarehouseService;
import com.zh.logistics.util.BaseContext;
import com.zh.logistics.util.DataFormat;

public class AsnServiceTest {

	ApplicationContext applicationContext;
	private AsnService asnService;
	
	@Before
	public void loadXml(){
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		asnService = (AsnService) applicationContext.getBean("asnService");
	}

	@Test
	public void getAsn(){
		
		Invoice invoice = new Invoice();
		int i = asnService.getAllcount(invoice);
		System.out.println("==========="+i);
//		System.out.println("==========="+invoice.getInvoiceDate());
//		System.err.println("==========="+invoice.getInvoiceFormatDate());
//		System.out.println("==========="+DataFormat.formatDateToString(invoice.getInvoiceDate()));
	}
	
	@Test
	public void TestGetAsn(){
		for (int i = 0; i < 20; i++) {
			Invoice invoice = new Invoice();
			InvoiceDetails details = new InvoiceDetails();
			details.setGoodsCode("234"+i);
			details.setGoodsNum(123);
			details.setGoodsUnitPrice(2.00);
			details.setGoodsSumPrice(246.0);
			details.setInvoice(invoice);
			InvoiceDetails details2 = new InvoiceDetails();
			details2.setGoodsCode("256"+i);
			details2.setGoodsNum(123);
			details2.setGoodsUnitPrice(2.00);
			details2.setGoodsSumPrice(246.0);
			details2.setInvoice(invoice);
			List<InvoiceDetails> list = new ArrayList<InvoiceDetails>();
			list.add(details);
			list.add(details2);
			
			invoice.setInvoiceNum("ASN100000"+i);
			invoice.setInvoiceDate(new Date());
			invoice.setInvoiceTime(new Timestamp(20140205));
			invoice.setInvoiceType(1);
			invoice.setWarehouseCode("124521");
			invoice.setInvoiceDetails(list);
			asnService.save(invoice);
		}
		
	}
}
