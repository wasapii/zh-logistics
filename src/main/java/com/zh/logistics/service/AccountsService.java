package com.zh.logistics.service;

import java.util.List;

import com.zh.logistics.base.BaseService;
import com.zh.logistics.entity.Accounts;

/**
 * 结算账户service
 * @zhanghao
 * 20150203
 * */
public interface AccountsService extends BaseService<Accounts>{

	public List<String> getAccountCode(String str);
}
