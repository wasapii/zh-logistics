package com.zh.logistics.dao;

import com.zh.logistics.base.BaseDao;
import com.zh.logistics.entity.Company;

public interface CompanyDao extends BaseDao<Company>{
	
	public Company getByCompanyCode(String companyCode);

	public String getNameByCompanyCode(String companyCode);
}
