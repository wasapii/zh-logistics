package com.zh.logistics.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.zh.logistics.entity.Company;
import com.zh.logistics.service.CompanyService;
import com.zh.logistics.util.FormatDateUtil;
import com.zh.logistics.util.Page;

/**
 * 单位信息action
 * 
 * @author zhanghao 20150203
 * 
 * */
public class CompanyAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(CompanyAction.class);

	private CompanyService companyService;

	private Company company;

	private List<Company> companyList;

	public String query() {
		try {
			int total = companyService.getAllcount(company);
			page.setTotal(total);
			page.setTotalPage(Page.caluTotalPage(total, page.getPageSize()));
			companyList = companyService.query(company, page);
			message = "success";
			logger.info("查询成功" + companyList);
			return "list";
		} catch (RuntimeException e) {
			logger.error("查询失败", e);
			throw e;
		}

	}

	public String queryAll() {
		try {
			company = new Company();
			int total = companyService.getAllcount(company);
			page = new Page();
			page.setTotal(total);
			page.setLocalPage(1);
			page.setTotalPage(Page.caluTotalPage(total, page.getPageSize()));
			companyList = companyService.query(company, page);
			message = "success";
			logger.info("查询成功" + companyList);
			return "list";
		} catch (RuntimeException re) {
			logger.error("查询失败", re);
			throw re;
		}

	}

	public String updateCompany() {
		try {
			companyService.update(company);
			return queryAll();
		} catch (RuntimeException re) {
			logger.error("更新失败", re);
			throw re;
		}

	}

	public String addCompany() {
		try {
			companyService.save(company);
			return queryAll();
		} catch (RuntimeException re) {
			logger.error("新增失败", re);
			throw re;
		}
	}

	public String deleteCompany() {
		try {
			logger.info("进入了delete方法，Id:" + id);
			String[] idList = FormatDateUtil.StringFormatArray(id);
			for (String delId : idList) {
				companyService.delete(Integer.parseInt(delId));
				logger.info("删除结算账户信息成功,删除ID:" + delId);
			}
			return queryAll();
		} catch (RuntimeException re) {
			logger.error("删除失败", re);
			throw re;
		}
	}

	public String toUpdate() {
		try {
			logger.info("获取到的仓库ID信息为：" + company.getId());
			company = companyService.getById(company.getId());
			logger.info("查询ID为：" + company.getId() + "的仓库信息为：" + company);
			return "update";
		} catch (RuntimeException re) {
			logger.error("查询失败", re);
			throw re;
		}
	}

	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}

}
