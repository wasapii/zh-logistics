package com.zh.logistics.util;

import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;

public class BaseContext {

	
	public final static Integer COMPANY_CATEGORY_SELLTOME = 1;//供货单位

	public final static Integer COMPANY_CATEGORY_BUYFROMME = 2;//购买单位

	public final static String DEFAULT_CATEGORY = "000000";//默认类别分类
	
	public final static String ASN_NUM_CREATE_HEAD = "ASN00";//进货单单号头内容
	
	/**
	 * 单位类型
	 * */
	public static enum CompanyCategoryMap {
		COMPANY_CATEGORY_SELLTOME("供货单位"), COMPANY_CATEGORY_BUYFROMME("购买单位");

		private String companyCate;

		public void setCompanyCate(String companyCate) {
			this.companyCate = companyCate;
		}

		public String getCompanyCate() {
			return companyCate;
		}

		private CompanyCategoryMap(String companyCate) {
			this.companyCate = companyCate;
		}

	}

	public final static Integer INVOICE_TYPE_ASN = 1;

	public final static Integer INVOICE_TYPE_SALE = 2;

	public final static Integer INVOICE_TYPE_ASN_RMA = -1;

	public final static Integer INVOICE_TYPE_SALE_RMA = -2;
	
	public final static Integer INVOICE_TYPE_ASN_OTHERS = 3;

	public final static Integer INVOICE_TYPE_SALE_OTHERS = 4;
	
	/**
	 * 单据类型
	 * */
	public static enum InvoiceType {
		ASN("进货单"), //1
		SALE("销售单"),//2
		ASN_RMA("进货退货单"),//-1
		SALE_RMA("销售退货单"),//-2
		ASN_OTHERS("其他进货单"),//3
		SALE_OTHERS("其他入库单");//4

		private String invoiceType;

		public String getInvoiceType() {
			return invoiceType;
		}

		public void setInvoiceType(String invoiceType) {
			this.invoiceType = invoiceType;
		}

		private InvoiceType(String invoiceType) {
			this.invoiceType = invoiceType;
		}

	}
	// 设置中文字体
	static {
		try {
			BaseFont bfChinese = BaseFont.createFont("STSong-Light",
					"UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			// 设置各种文本格式
			Font f2 = new Font(bfChinese, 2, Font.NORMAL);
			Font f6 = new Font(bfChinese, 6, Font.NORMAL);
			Font f10 = new Font(bfChinese, 10, Font.NORMAL);
			Font f12 = new Font(bfChinese, 12, Font.BOLD);
			String[] title = new String[] { "订单号", "商品名", "订单来源", "座席工号",
					"经销商名称", "订单创建日期", "商品价格", "成本价", "数量", "总价" };
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
