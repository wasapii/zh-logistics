package com.zh.logistics.dao;

import java.util.List;

import com.zh.logistics.base.BaseDao;
import com.zh.logistics.entity.Accounts;

public interface AccountsDao extends BaseDao<Accounts>{

	public List<String> getAccountCode(String str);
}
