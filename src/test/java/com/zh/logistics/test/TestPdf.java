package com.zh.logistics.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.zh.logistics.entity.Warehouse;

public class TestPdf {
	public static String[] title = new String[] { "仓库编号", "仓库名称", "地址", "联系人","联系电话","1"};
	@Test
	public void test() throws Exception {
		// 首先定义个document
		Document document = new Document(PageSize.A4.rotate());
		try {
			// 然后得到pdfWriter一般用不到，高级的用的到
			PdfWriter.getInstance(document, new FileOutputStream(
					"d://test6.pdf"));
			document.open();
			System.out.println(new String("sfs就是开发商"));
			// 把所有的信息都增加到document就好了
			document.add(new Paragraph("就是开发商是开放式好好lsjdfjsjf sfk", new Font(
					BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
							BaseFont.NOT_EMBEDDED), 12, Font.NORMAL)));

			document.add(TestPdf.createPdfPtable());
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new DocumentException(e);
		}
		document.close();
	}

	public static PdfPTable createPdfPtable() throws DocumentException,
			IOException {
		PdfPTable pdfpTable = new PdfPTable(title.length);
		pdfpTable.setWidthPercentage(100);
		pdfpTable.setHorizontalAlignment(pdfpTable.ALIGN_LEFT);

		TestPdf.createTitle(pdfpTable);
		TestPdf.createContext(pdfpTable);
		return pdfpTable;
	}

	public static PdfPTable createTitle(PdfPTable table)
			throws DocumentException, IOException {
		PdfPCell cell = new PdfPCell();

		// cell.setBackgroundColor(new BaseColor(213, 141, 69));
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

		for (int i = 0; i < title.length; i++) {
			cell.setPhrase(new Paragraph(title[i], new Font(BaseFont
					.createFont("STSong-Light", "UniGB-UCS2-H",
							BaseFont.NOT_EMBEDDED), 12, Font.NORMAL)));
			table.addCell(cell);
		}
		return table;
	}
	
	public static PdfPTable createContext(PdfPTable table) throws DocumentException, IOException{
		PdfPCell cell = new PdfPCell();
		List<Warehouse> list = TestPdf.getList();
		for (Warehouse warehouse : list) {
			cell.setPhrase(new Paragraph(warehouse.getWarehouseCode(),new Font(BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED), 12, Font.NORMAL)));
			table.addCell(cell);
			cell.setPhrase(new Paragraph(warehouse.getWarehouseName(),new Font(BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED), 12, Font.NORMAL)));
			table.addCell(cell);
			cell.setPhrase(new Paragraph(warehouse.getAddress(),new Font(BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED), 12, Font.NORMAL)));
			table.addCell(cell);
			cell.setPhrase(new Paragraph(warehouse.getContacts(),new Font(BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED), 12, Font.NORMAL)));
			table.addCell(cell);
			cell.setPhrase(new Paragraph(warehouse.getTel(),new Font(BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED), 12, Font.NORMAL)));
			table.addCell(cell);
			table.addCell(Image.getInstance("d://test.jpg"));
		}
		
		
		return table;
	}
	
	
	public static List<Warehouse> getList(){
		List<Warehouse> list = new ArrayList<Warehouse>();
		Warehouse warehouse = new Warehouse();
		warehouse.setWarehouseCode("W00001");
		warehouse.setWarehouseName("测试仓库");
		warehouse.setAddress("这里有个测试仓库");
		warehouse.setContacts("测试仓库管理员");
		warehouse.setTel("13526584965");
		
		list.add(warehouse);
		
		Warehouse warehouse1 = new Warehouse();
		warehouse1.setWarehouseCode("W00002");
		warehouse1.setWarehouseName("测试仓库2");
		warehouse1.setAddress("这里有个测试仓库2");
		warehouse1.setContacts("测试仓库管理员2");
		warehouse1.setTel("13526584965");
		
		list.add(warehouse1);
		
		return list;
	}
}
