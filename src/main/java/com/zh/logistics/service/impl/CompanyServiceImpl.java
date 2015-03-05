package com.zh.logistics.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zh.logistics.dao.CompanyDao;
import com.zh.logistics.entity.Company;
import com.zh.logistics.service.CompanyService;
import com.zh.logistics.util.Page;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService{

	private CompanyDao companyDao;

	@Override
	public Company save(Company t) {
		return companyDao.save(t);
	}

	@Override
	public void update(Company t) {
		companyDao.update(t);
	}

	@Override
	public List<Company> query(Company t, Page page) {
		return companyDao.query(t, page);
	}

	@Override
	public void delete(int id) {
		companyDao.delete(id);		
	}

	@Override
	public int getAllcount(Company t) {
		return companyDao.getAllcount(t);
	}

	@Override
	public Company getById(int id) {
		return companyDao.getById(id);
	}

	public CompanyDao getCompanyDao() {
		return companyDao;
	}

	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}
	
}
