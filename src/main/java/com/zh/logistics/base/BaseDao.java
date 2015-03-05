package com.zh.logistics.base;

import java.util.List;

import com.zh.logistics.util.Page;

public interface BaseDao<T> {
	
	public T save(T t);
	
	public List<T> query(T t, Page page);
	
	public void update(T t);
	
	public T getById(int id);
	
	public void delete(int id);
	
	public int getAllcount(T t);

}
