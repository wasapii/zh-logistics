package com.zh.logistics.util;

public class Page {
	
	private int totalPage;//记录总页数
	
	private int total;//记录总数
	
	private int localPage;//当前页
	
	private int pageSize = 15;//每页显示条数

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getLocalPage() {
		return localPage;
	}

	public void setLocalPage(int localPage) {
		this.localPage = localPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * 计算查询数据库中的初始序号
	 * */
	public static int getStartNO(Page page){
		 return (page.getLocalPage() - 1) * page.getPageSize();
	}
	
	public static int caluTotalPage(int total,int pageSize){
		if (total % pageSize == 0) {
			return total / pageSize;
		}
		return total / pageSize + 1;
	}
}
